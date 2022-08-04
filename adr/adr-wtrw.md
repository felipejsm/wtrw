## ADR 1: Como são formuladas e apresentadas as dicas(HINTS)   
O CRUD já está funcionando mas ele ficará disponível em sua totalidade para o admin   
Disponível para algum client serão somente os endpoints fornecendo as dicas
Como deve ser o mecanismo:
Logo de início, apresentar a frase 'Who's that right-winger?'
E logo abaixo, linha 0 frase acima
linha 1, primeira dica: phrases
linha N, enésima dica: networth
linha N+1, enésima dica: gender

Mas nem todas infos devem ser apresentadas, são elas:
fullname, picture   

mas claro, deve ter uma opção de 'revelar' onde já apresenta a foto e seguida de todas as infos
Caso não desista, será fornecida 3/4 dicas no máximo e com isso será revelado   


Para o futuro: a picture ser uma foto no começo sim mas depois fornecer formato ASCII
## Decision   
Um endpoint único é o que preciso para fornecer a dica
GET > v1/hint -> json incompleto | aqui deve ter o controle do número de chamadas | utilizar token?  
GET > v1/revealed -> json completo
## Status  
*Proposed*   

## Consequences   

