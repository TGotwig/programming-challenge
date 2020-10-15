install:
	mvn verify

run:
	mvn exec:java -Dexec.args="--weather src/main/resources/de/exxcellent/challenge/weather.csv"

run-all:
	mvn exec:java -Dexec.args="--weather src/main/resources/de/exxcellent/challenge/weather.csv --football src/main/resources/de/exxcellent/challenge/football.csv"

test:
	mvn test

# Generates a file with linting-issues: target/checkstyle-result.xml
lint:
	mvn checkstyle:checkstyle

clean:
	mvn clean
