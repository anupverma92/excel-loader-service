# excel-loader-service

Steps need to follow to run config-loader service:
1. Place the schema Excel file under "src/main/resources/files" folder which data needs to be uploaded in MongoDb Collection.
2. Update the Excel file path(config.excelPath) with respect to src folder(src/main/resources/files/ClientConfiguration.xlsx) in application.properties file under resources folder.
3. Run ConfigLoaderApplication file (com/anup/excelloader/ExcelLoaderApplication.java).
4. Validate data in "Client_configuration_collection" in MongoDB collection in the DB path.



Application internal working:

1. We need to give the DB environment  path to store the excel data in the "src/main/resources/application.properties" or make profile active and give the property in active profile.
   For ex: spring.profiles.active=qa   
   config.excelPath=src/main/resources/files/ClientConfiguration.xlsx

2. We are going to use Poiji library(added as maven dependency in pom.xml) to read data from the excel.
   Poiji is a tiny thread-safe Java library that provides one way mapping from Excel sheets to Java classes. In a way it lets us convert each row of the specified excel data into Java objects. Poiji uses Apache Poi (the Java API for Microsoft Documents) under the hood to fulfill the mapping process.
   below is the maven dependency and Git info  for Poiji.

        <dependency>
			<groupId>com.github.ozlerhakan</groupId>
			<artifactId>poiji</artifactId>
			<version>4.1.1</version>
		</dependency>
Link: https://github.com/ozlerhakan/poiji/blob/master/README.adoc#poiji

3. After reading the excel file, application iterate the every row and fetch the data from every column in excel and set in respective java object.
4. After storing in java object data is persisted in Mongodb as a document(Before saving in db first data will be validated in the db, it it exists it will be deleted).
5. Data saving process will happen row by row. Every complete row data  is treated as a document in Mongodb collection.
6. After successful completion of running process, data can be validated in the db path as passed the environment in property file.