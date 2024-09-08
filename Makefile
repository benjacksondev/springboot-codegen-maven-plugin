.PHONY=build

build:
	mvn clean install

test:
	mvn test

clean-snapshots:
	rm -rf src/test/java/__snapshots_