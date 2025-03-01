package br.luciano.JdbcPagingReader_batch.step;

import br.luciano.JdbcPagingReader_batch.dominio.Cliente;
import org.springframework.batch.core.Step;
import org.springframework.batch.core.repository.JobRepository;
import org.springframework.batch.core.step.builder.StepBuilder;
import org.springframework.batch.item.ItemReader;
import org.springframework.batch.item.ItemWriter;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.transaction.PlatformTransactionManager;

@Configuration
public class SkipExceptionStepConfig {
    @Autowired
    PlatformTransactionManager transactionManager;

    @Bean
    public Step skipExceptionStep(ItemReader<Cliente> skipExceptionReader, ItemWriter<Cliente> skipExceptionWriter, JobRepository jobRepository) {
        return new StepBuilder("skipExceptionStep", jobRepository)
                .<Cliente, Cliente>chunk(11, transactionManager)
                .reader(skipExceptionReader)
                .writer(skipExceptionWriter)
                .faultTolerant()
                .skip(Exception.class)
                .skipLimit(2)
                .build();
    }
}
