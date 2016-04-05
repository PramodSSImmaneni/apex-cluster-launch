package com.datatorrent.claunch;

import org.junit.Test;

import org.apache.hadoop.conf.Configuration;

import com.datatorrent.api.DAG;
import com.datatorrent.api.StreamingApplication;

import com.datatorrent.lib.io.ConsoleOutputOperator;
import com.datatorrent.lib.testbench.RandomEventGenerator;

/**
 * Created by pramod on 4/5/16.
 */
public class LauncherTest {

    @Test
    public static void testLauch() throws Exception
    {
        StreamingApplication app = new StreamingApplication() {
            public void populateDAG(DAG dag, Configuration configuration) {
                RandomEventGenerator randomEventGenerator = dag.addOperator("Generator", RandomEventGenerator.class);
                ConsoleOutputOperator consoleOutput = dag.addOperator("Console", ConsoleOutputOperator.class);
                dag.addStream("data", randomEventGenerator.integer_data, consoleOutput.input);
            }
        };
        Launcher.launch(app, "testapp");
    }

    public static void main(String[] args) throws Exception
    {
        LauncherTest.testLauch();
    }
}
