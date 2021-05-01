# docker image build -t atividadedac/banco ./postgres
# docker container run -p 5433:5432 --name bd -d atividadedac/banco

cd ./app 
mvn clean package
cd ..
docker image build -t atividadedac/app ./app
docker container run -p 8080:8080 --name app -d atividadedac/app #--link bd:host-banco 
# echo 'fim'