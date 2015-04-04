def buildLogFile = new File( basedir, "build.log");

assert buildLogFile.text.contains ('[INFO] BUILD SUCCESS')
assert buildLogFile.text.contains ('[INFO] UNIT TEST SUMMARY')
assert buildLogFile.text.contains ('[INFO] Tests run Failures Errors Skipped Elapsed    ClassName')
assert buildLogFile.text.contains ('[INFO]                                   Time (sec)')
assert buildLogFile.text.contains ('[INFO] SLOWEST UNIT TEST SUMMARY')
