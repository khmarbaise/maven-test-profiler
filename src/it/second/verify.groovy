def buildLogFile = new File( basedir, "build.log");

assert buildLogFile.text.contains ('[INFO] BUILD SUCCESS')
assert buildLogFile.text.contains ('[INFO] Maven Test Profiler 0.1 started.')
