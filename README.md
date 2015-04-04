# Maven Test Profiler

Often you have the problem that in large builds you need to find
the list of the `bad tests` which means to find those tests
which are taking the most time to run.

This is an [EventSpy][1] implementation which collects all the information
of all unit tests which have been ran by maven-surefire-plugin
and make a summarization output at the end of the build.
This means every suite is listed separately with their approriate 
run time afterwards you get a list of the worst five test suites
which gives you a hint where to look for bad tests.

In case of test failures you will get appropriate lines at the end of the
build (WARNINGS).

If you like to use this EventSpy you need to put the resulting jar
file of this project into the `${M2_HOME}/lib/ext` directory.

The jar file with the classifier `-mvn325` is intended to be used with
Maven 3.1.1 until Maven 3.2.5 where as the usual file without classifier
is intended to use with Maven 3.3.1 and above.

Here's an example of what the output will look like:

```
[INFO] ------------------------------------------------------------------------
[INFO] BUILD SUCCESS
[INFO] ------------------------------------------------------------------------
[INFO] Total time: 50.828s
[INFO] Finished at: Mon Feb 16 21:08:08 CET 2015
[INFO] Final Memory: 56M/654M
[INFO] ------------------------------------------------------------------------
[INFO] UNIT TEST SUMMARY
[INFO] Tests run Failures Errors Skipped Elapsed Time ClassName
[INFO]                                          (sec)
[INFO]         9        0      0       0        0.013 com.soebes.supose.config.filter.FilterFileTest
[INFO]         1        0      0       0        0.000 com.soebes.supose.config.filter.FilterPartialTest
[INFO]         6        0      0       0        0.003 com.soebes.supose.config.filter.FilteringTest
[INFO]        17        0      0       0        0.017 com.soebes.supose.config.filter.FilteringWithExcludeDifferentRepositoryIdTest
[INFO]        15        0      0       0        0.018 com.soebes.supose.config.filter.FilteringWithExcludeTest
[INFO]         3        0      0       0        0.000 com.soebes.supose.core.config.ConfigurationRepositoriesTest
[INFO]         7        0      0       0        0.017 com.soebes.supose.core.lucene.LuceneTest
[INFO]         3        0      0       0        0.018 com.soebes.supose.core.scan.IndexMergeTest
[INFO]         1        0      0       0        0.000 com.soebes.supose.core.utility.FileExtensionPropertyTest
[INFO]         1        0      0       0        0.028 com.soebes.supose.core.parse.java.JavaParserTest
[INFO]        11        1      0       0        0.005 com.soebes.supose.core.utility.FileNameTest
[INFO]         1        0      0       0        0.020 com.soebes.supose.core.recognition.RenameRecognitionTest
[INFO]        28        0      0       0        0.086 com.soebes.supose.core.scan.SearchRepositoryGetQueryTest
[INFO]         3        0      0       0        0.021 com.soebes.supose.core.config.ini.IniTest
[INFO]         1        0      0       0        0.035 com.soebes.supose.core.recognition.TagBranchRecognitionTest
[INFO]        38        0      0       0        0.115 com.soebes.supose.core.scan.SearchRepositoryGetResultTest
[INFO]         1        0      0       0        0.003 com.soebes.supose.core.config.RepositoryJobConfigurationTest
[INFO]        22        0      0       0        0.129 com.soebes.supose.cli.SuposeCLITest
[INFO] --------- -------- ------ ------- ------------
[INFO]       168        1      0       0        0.528
[INFO] ========= ======== ====== ======= ============
[INFO]
[INFO] Rate: 99.405 %
[INFO] ------------------------------------------------------------------------
[INFO] SLOWEST UNIT TEST SUMMARY
[INFO] Tests run Failures Errors Skipped Elapsed Time ClassName
[INFO]                                          (sec)
[INFO]        22        0      0       0        0.129 com.soebes.supose.cli.SuposeCLITest
[INFO]        38        0      0       0        0.115 com.soebes.supose.core.scan.SearchRepositoryGetResultTest
[INFO]        28        0      0       0        0.086 com.soebes.supose.core.scan.SearchRepositoryGetQueryTest
[INFO]         1        0      0       0        0.035 com.soebes.supose.core.recognition.TagBranchRecognitionTest
[INFO]         1        0      0       0        0.028 com.soebes.supose.core.parse.java.JavaParserTest
[WARNING] Failed Test case: testF70(com.soebes.supose.core.utility.FileNameTest)
[WARNING]        The path is not as expected. expected [&&] but found [/] java.lang.AssertionError
```

Prerequisites for this is Maven 3.1.1 and Java 1.6 as run time.

[1]: http://maven.apache.org/ref/3.0.3/maven-core/apidocs/org/apache/maven/eventspy/AbstractEventSpy.html
