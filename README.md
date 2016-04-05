# Apex cluster launch

### API

The `Launcher` class provides the API

### Test

The `LauncherTest` class shows how to use the API

### Running the test

Below is a sample command to run the test app provided in the package. This should also serve as an example on how to use the launcher.

java -classpath /opt/datatorrent/releases/3.2.0/lib/*:cluster-launch-1.0-SNAPSHOT-tests.jar:cluster-launch-1.0-SNAPSHOT.jar:\`hadoop classpath\`:malhar-library-3.2.0-incubating.jar com.datatorrent.claunch.LauncherTest