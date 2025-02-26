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
public class JdbcCursorReaderStepConfig {
    @Autowired
    PlatformTransactionManager transactionManager;

    @Bean
    public Step jdbcCursorReaderStep(ItemReader<Cliente> jdbcCursorReader,
                                     ItemWriter<Cliente> jdbcCursorWriter, JobRepository jobRepository) {
        return new StepBuilder("jdbcCursorReaderStep", jobRepository)
                .<Cliente, Cliente>chunk(1, transactionManager)
                .reader(jdbcCursorReader)
                .writer(jdbcCursorWriter)
                .build();

    }
}
