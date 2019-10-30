package br.com.klenne.model

import br.com.klenne.db.DataBaseServicos

class Servicos {
    val servicos = listOf(
        "Insert Into  ${DataBaseServicos.TABLE_NAME} (${DataBaseServicos.NOME},${DataBaseServicos.PRECO},${DataBaseServicos.RESUMO},${DataBaseServicos.DESCRICAO}) values('Mega-Sena','De 3,50R$ até 17.517,50R$','A Mega-Sena paga milhões para o acertador dos 6 números sorteados.','Como jogar\n" +
                "A Mega-Sena paga milhões para o acertador dos 6 números sorteados. Ainda é possível ganhar prêmios ao acertar 4 ou 5 números dentre os 60 disponíveis no volante de apostas. Para realizar o sonho de ser o próximo milionário, você deve marcar de 6 a 15 números do volante, podendo deixar que o sistema escolha os números para você (Surpresinha) e/ou concorrer com a mesma aposta por 2, 4 ou 8 concursos consecutivos (Teimosinha).\n" +
                "\n" +
                "Sorteios\n" +
                "Os sorteios da Mega-Sena são realizados duas vezes por semana, às quartas e aos sábados. Para adequar o número do concurso da Mega da Virada, que deve ter final 0 ou 5 foram criadas as Mega-Semanas que são exclusividade da Mega-Sena. Os sorteios ocorrem em datas predeterminadas ao longo do ano. Na ocasião são realizados três concursos semanais, às terças, quintas e sábados. Confira no cronograma de sorteio ou em Comunicados Importantes.\n" +
                "\n" +
                "Apostas\n" +
                "A aposta mínima, de 6 números, custa R\$ 3,50. Quanto mais números marcar, maior o preço da aposta e maiores as chances de faturar o prêmio mais cobiçado do país.\n" +
                "\n" +
                "Premiação\n" +
                "O prêmio bruto corresponde a 43,35% da arrecadação. Dessa porcentagem:\n" +
                "\n" +
                "    35% são distribuídos entre os acertadores dos 6 números sorteados (Sena);\n" +
                "\n" +
                "    19% entre os acertadores de 5 números (Quina);\n" +
                "\n" +
                "    19% entre os acertadores de 4 números (Quadra);\n" +
                "\n" +
                "    22% ficam acumulados e são distribuídos aos acertadores dos 6 números nos concursos de final 0 ou 5.\n" +
                "\n" +
                "    5% ficam acumulados para a primeira faixa - sena - do último concurso do ano de final 0 ou 5 (Mega da Virada).\n" +
                "\n" +
                "Recebimento de prêmios\n" +
                "\n" +
                "Você pode receber seu prêmio em qualquer casa lotérica credenciada ou nas agências da Caixa. Caso o prêmio líquido seja superior a R\$ 1.332,78 (bruto de R\$ 1.903,98) o pagamento pode ser realizado somente nas agências da Caixa. Valores iguais ou acima de R\$ 10.000,00 são pagos após 2 dias de sua apresentação na agência da Caixa.\n" +
                "\n" +
                "Acumulação\n" +
                "Não havendo acertador em qualquer faixa, o valor acumula para o concurso seguinte, na respectiva faixa de premiação. Não deixe de conferir o seu bilhete de aposta.\n" +
                "\n" +
                "Os prêmios prescrevem 90 dias após a data do sorteio. Após esse prazo, os valores são repassados ao tesouro nacional para aplicação no FIES - Fundo de Financiamento ao Estudante do Ensino Superior.');"


        ,
        "Insert Into  ${DataBaseServicos.TABLE_NAME} " +
                "(${DataBaseServicos.NOME},${DataBaseServicos.PRECO},${DataBaseServicos.RESUMO},${DataBaseServicos.DESCRICAO}) " +
                "values('Quina','de 1,50R$ até 4.504,50R$','Concorra a prêmios grandiosos com a Quina: basta marcar de 5 a 15 números dentre os 80 disponíveis no volante e torcer. Caso prefira o sistema pode escolher os números para você através da Surpresinha.'," +
                "'Como jogar\n" +
                "Concorra a prêmios grandiosos com a Quina: basta marcar de 5 a 15 números dentre os 80 disponíveis no volante e torcer. Caso prefira o sistema pode escolher os números para você através da Surpresinha.\n" +
                "\n" +
                "Ganham prêmios os acertadores de 2, 3, 4 ou 5 números. Você ainda pode concorrer com a mesma aposta por 3, 6, 12, 18 ou 24 concursos consecutivos com a Teimosinha.\n" +
                "\n" +
                "Sorteios\n" +
                "São 6 sorteios semanais: de segunda-feira a sábado, às 20h.\n" +
                "\n" +
                "Premiação\n" +
                "O prêmio bruto corresponde a 43,35% da arrecadação. Deste valor:\n" +
                "\n" +
                "   35% são distribuídos entre os acertadores dos 5 números,\n" +
                "\n" +
                "   19% entre os acertadores de 4 números,\n" +
                "\n" +
                "   20% entre os acertadores de 3 números,\n" +
                "\n" +
                "   11% entre os acertadores de 2 números e\n" +
                "\n" +
                "   15% acumulam para os acertadores dos 5 números da Quina de São João.\n" +
                "\n" +
                "Não havendo acertador em qualquer faixa de premiação, os valores acumulam para o concurso seguinte, nas respectivas faixas.\n" +
                "\n" +
                "Recebimento de prêmios\n" +
                "\n" +
                "Você pode receber seu prêmio em qualquer casa lotérica credenciada ou nas agências da Caixa. Caso o prêmio líquido seja superior a R\$ 1.332,78 (bruto de R\$ 1.903,98) o pagamento pode ser realizado somente nas agências da Caixa. Valores iguais ou acima de R\$ 10.000,00 são pagos após 2 dias de sua apresentação na agência da Caixa.\n" +
                "\n" +
                "Apostas\n" +
                "O preço da aposta com 5 números é de R\$ 1,50. Quanto mais números marcar, maior o preço da aposta e maiores as chances de ganhar.\n" +
                "\n" +
                "Acumulação\n" +
                "Não existindo aposta premiada, em concurso regular, na 1ª, 2ª, 3ª ou 4º faixa(s), o(s) valor(es) acumula(m) para o concurso seguinte, na 1ª faixa de premiação. No concurso especial do dia 24 de junho de cada ano, a regra de acumulação segue o seguinte critério:\n" +
                "- Não existindo aposta premiada na 1ª faixa (quina), este valor será somado ao valor da 2ª faixa e rateado entre as apostas que contiverem 4 prognósticos certos (quadra);\n" +
                "- Não existindo apostas premiadas na 1ª faixa (quina) e na 2ª faixa (quadra), os valores destinados a prêmios para estas faixas serão somados ao valor da 3ª faixa, e rateados entre as apostas que contiverem 3 prognósticos certos (terno);\n" +
                "- Não existindo apostas premiadas na 1ª faixa (quina), na 2ª faixa (quadra) e na 3ª faixa (terno) os valores destinados a prêmios para estas faixas serão somados ao valor da 4ª faixa, e rateados entre as apostas que contiverem 2 prognósticos certos (duque);\n" +
                "- Não existindo apostas premiadas em quaisquer faixas de premiação, os valores acumulam para o concurso seguinte, na 1ª faixa de premiação.\n" +
                "\n" +
                "Os prêmios prescrevem 90 dias após a data do sorteio. Após esse prazo, os valores são repassados ao Tesouro Nacional para aplicação no FIES - Fundo de Financiamento ao Estudante do Ensino Superior.\n" +
                "\n');",

        "Insert Into  ${DataBaseServicos.TABLE_NAME} \n" +
                "(${DataBaseServicos.NOME},${DataBaseServicos.PRECO},${DataBaseServicos.RESUMO},${DataBaseServicos.DESCRICAO}) \n" +
                "values('Pagamento de fatura',' ','Um dos serviços mais populares da casa lotérica é o pagamento de faturas. Além de faturas, o indivíduo pode pagar boletos e carnês.','Um dos serviços mais populares da casa lotérica é o pagamento de faturas. Além de faturas, o indivíduo pode pagar boletos e carnês.\n" +
                "\n" +
                "Quem ainda não tem conta em banco ou não sabe mexer direito nos caixas eletrônicos, acaba não usando as facilidades que os bancos oferecem em pagamentos de conta e possuem algumas dificuldades para realizar o pagamento.\n" +
                "\n" +
                "Podem ser pagos os seguintes itens:\n" +
                "\n" +
                "Faturas de cartões de crédito de qualquer unidade bancária, com limite de 2 mil reais.\n" +
                "Pagamento de fatura de contas da Caixa econômica federal com limite de 2 mil reais por transação.\n" +
                "Contas básicas: água, luz, telefones, gás, etc.\n" +
                "Boleto bancário da Caixa, pagamento em dinheiro com limite de 2 mil reais e pagamento em cheque com limite de mil reais.\n" +
                "Boletos bancários de qualquer banco com limite de 700 reais.\n" +
                "Contas imobiliárias (parcelamento financeiro) realizados pela Caixa Econômica, com limite de 2 mil reais por dia, dinheiro ou cheque.');",


        "Insert Into  ${DataBaseServicos.TABLE_NAME} \n" +
                "(${DataBaseServicos.NOME},${DataBaseServicos.PRECO},${DataBaseServicos.RESUMO},${DataBaseServicos.DESCRICAO}) \n" +
                "values('Saque',' ','Dá para saber dinheiro na casa lotérica? Sim! Dá para conseguir sacar dinheiro de contas da Caixa, tanto conta corrente como em poupança, inclusive contas do Banco do Brasil.','Dá para saber dinheiro na casa lotérica? Sim! Dá para conseguir sacar dinheiro de contas da Caixa, tanto conta corrente como em poupança, inclusive contas do Banco do Brasil.\n" +
                "\n" +
                "Os saques de conta corrente ou de poupança com apresentação de cartão podem ser feitos com o limite de R\$ 1.500 reais por dia.\n" +
                "\n" +
                "Também é possível sacar o benefício Bolsa Família, mas para isso o cidadão precisa estar portando o cartão magnético.\n" +
                "\n" +
                "Além disso, é possível também sacar o INSS recebido pela Caixa, o Seguro desemprego, o PIS (com apresentação do cartão cidadão). E o FGTS com limite de R\$ 1.500,00 reais.');"
    )


}