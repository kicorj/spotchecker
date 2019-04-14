# Build
mvn clean package && docker build -t br.com.projuris.challenge/spotchecker .

# RUN

docker rm -f spotchecker || true && docker run -d -p 8080:8080 -p 4848:4848 --name spotchecker br.com.projuris.challenge/spotchecker # spotchecker
