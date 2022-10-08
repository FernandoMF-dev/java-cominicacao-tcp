# Comunicação TCP e algoritimo Apriori em Java
Configuração de uma comunicação TCP entre um cliente e um servidor utilizando Java.<br>
Atividade proposta pelo professor **Vanderson José Idelfonso Silva** no curso de **Bacharelado de Sistemas de Informação**.<br>
Desenvolvida pelos alunos: **Fernando Martins**, **Leonardo de Souza** e **Mateus Padovan**.

**Instituto Federal de Educação, Ciência e Tecnologia do Espírito Santo (IF ES). Campus Colatina**

<hr>

## Enunciado
Elabore uma aplicação java distribuída que permita o registro das vendas realizadas em um estabelecimento comercial.

O referido estabelecimento venderá apenas:
<br>(1) Pão;
<br>(2) Leite;
<br>(3) Café;
<br>(4) Suco;
<br>(5) Bolachas;
<br>(6) Queijo;
<br>(7) Presunto;
<br>(8) Manteiga.

A aplicação não deverá manter cadastro de qualquer cliente do estabelecimento, mas deverá identificar uma venda como sendo um subconjunto dos 8 produtos acima relacionados, adquiridos por um dado cliente em uma data e horário específicos.

Ou seja, a aplicação não precisa identificar quem foi o cliente responsável por uma determinada venda. Porém deve identificar que, em uma venda específica (a venda de número 37) o cliente levou Pão, Leite e manteiga.

Quantidades e preços relacionados a esses itens da compra não deverão ser armazenados nem tratados pela aplicação.

Importa saber que na venda número 42 foram vendidos Queijo e Suco, enquanto na venda número 56 foram vendidos Café, Queijo, Bolachas e Presunto.

Os dados de venda são registrados em clientes e enviados para armazenamento em um ArrayList no servidor da aplicação.

O gerente do estabelecimento comercial, através de um formulário próprio, poderá solicitar ao servidor:

<br>1. A relação de todas as vendas armazenadas para apresentação em seu formulário;
<br>2. Regras de Associação geradas pelo algoritmo Apriori no lado do Servidor.

Os caixas do estabelecimento, através de um formulário específico, no  lado do cliente, apenas enviarão novas informações de vendas para serem armazenadas no servidor.

A comunicação entre clientes e servidor deverá ocorrer por intermédio da API Java TCP.

O servidor deverá criar um Thread para cada nova solicitação de um cliente e deverá atender a 3 diferentes solicitações destes:

<br>1. Armazenar uma nova venda no ArrayList.
<br>2. Devolver para o solicitante uma consulta com todas as vendas armazenadas em seu ArrayList.
<br>3. Executar o algoritmo apriori sobre os dados existentes no ArrayList e encaminhar as regras de associação geradas para o cliente solicitante.

Faça uso da serialização de objetos para transmitir os dados do servidor para os clientes e vice versa.

**Atenção:** Em relação ao algoritmo Apriori, gere regras de associação para apenas dois produtos (produto1 ==> produto2). Não há a necessidade de gerar regras para três (produto1, produto2 ==> produto3), quatro (produto1, produto2, produto3 ==> produto4) ou mais produtos.