# Rental-rental

branch com initial conf application.yaml

base-path /rental

ALTERAR ESSE METODO PARA POST POIS É UMA INSERÇÃO DE REGISTRO
```
POSt /rentalpre
esse endpoint faz uma pré-alocação do registrando na tabela rental um registro com
status "processando"
{
	"inventory_id": 488,
	"customer_id": 31,
	"staff_id": 1,
	"film_id": 16050
}
```

TO-DO ALTERAR ESSE METEDO
```
PATCH /rentalsucces?rental_id=X&status="aprovado||negado"
esse endpoint recebe o ok da api de PAGAMENTO e atualizar o status do registro
do endpoint acima como "sucesso"
```
ALTERAR ESSE METODO PARA POST POIS SIGNIFICA A REINSERÇÃO DO DVD NO INVENTARIO
```
GET /rentalreturn/{inventory}/{customer}
esse endpoint recebe o retorno do dvd da api RETURN
```


branch com initial conf application.yaml com jib configurado

###CMD BUILD USANDO JIB PARA BUILD DOCKER IMAGE COM A TAG PASSADA VIA ARGUMENTO
gradle jibDockerBuild -Ptag=100 # tag do build da imagem docker

###CMD RODA CONTAINER SETANDO O IP DO PG E A PORTA PARA A API CONECTAR NO BANCO
###VARIAVEIS IP_PG e PORT ESTÃO REFERENCIADAS NO application.yaml
docker run -d --name customer --env ip_pg=192.160.XX.XX --env PORT=5436  colabdevops/rental:1