install:
	mvn verify

run:
	mvn exec:java

test:
	mvn test

# Generates a file with linting-issues: target/checkstyle-result.xml
lint:
	mvn checkstyle:checkstyle

clean:
	mvn clean
