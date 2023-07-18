package com.benaya.assignments.clientapi.listeners;

import com.benaya.assignments.clientapi.model.Client;
import com.benaya.assignments.clientapi.service.ClientService;
import lombok.Getter;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.apache.commons.csv.CSVFormat;
import org.apache.commons.csv.CSVParser;
import org.apache.commons.csv.CSVRecord;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.autoconfigure.condition.ConditionalOnProperty;
import org.springframework.context.event.ContextRefreshedEvent;
import org.springframework.context.event.EventListener;
import org.springframework.stereotype.Component;

import java.io.IOException;
import java.io.Reader;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.atomic.AtomicInteger;

@Component
@RequiredArgsConstructor
@ConditionalOnProperty(name = "init.database", havingValue = "true")
@Getter
@Slf4j
public class InitializeDatabaseListener {

    private final ClientService clientService;

    @Value("${init.database.dump}")
    private String csvFileName;

    private final AtomicInteger batchCounter = new AtomicInteger(0);

    @EventListener
    public void onApplicationEvent(ContextRefreshedEvent event) {
        int MAX_BATCH_SIZE = 100;
        try (Reader reader = Files.newBufferedReader(Paths.get(csvFileName))
             ; CSVParser csvParser = new CSVParser(reader, CSVFormat.DEFAULT
                .builder()
                .setHeader().setSkipHeaderRecord(true)
                .setTrim(true)
                .setIgnoreEmptyLines(true)
                .setIgnoreHeaderCase(true)
                .build())) {
            List<Client> tempClientList = new ArrayList<>();
            for (CSVRecord csvRecord : csvParser) {
                Client client = Client.builder()
                        .id(csvRecord.get("ID"))
                        .name(csvRecord.get("Name"))
                        .email(csvRecord.get("Email"))
                        .phone(csvRecord.get("Phone"))
                        .ip(csvRecord.get("IP"))
                        .build();
                tempClientList.add(client);
                if(tempClientList.size() == MAX_BATCH_SIZE){
                    clientService.addBatchClients(tempClientList);
                    batchCounter.incrementAndGet();
                    tempClientList.clear();
                    if(batchCounter.get() > 0 && batchCounter.get() % 30 == 0){
                        log.info("Progress: "+ 100 * batchCounter.get()/300);  // log the progress
                    }
                }
            }
        } catch (
                IOException e) {
            throw new RuntimeException(e);
        }
    }
}