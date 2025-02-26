### Projeto utilizando Jdbc Paging Item Reader
O projeto faz a leitura em um banco de dados PostgreSQL via ItemReader e utiliza um ItemWriter para externar a informação lida.

O tamanho da paginação  é determinado na classe "JdbcPagingReaderReaderConfig" no método pageSize.

#### Requisitos
- Ter as variáveis de ambiente devidamente preenchidas com as credencias do banco
```shell
DB_USER=usuario_do_banco;DB_PASSWORD=senha_do_banco
```

- Ter um banco "spring_batch", onde serão armazenados os metadados do batch, e um "app", onde serão armazenados os dados da aplicação.

- No pacote 'resources', existe um arquivo data.sql que contém instruções 'INSERT' para execução.
