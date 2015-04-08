package com.aerospike.aql;

import org.junit.runner.RunWith;
import org.junit.runners.Suite;
import org.junit.runners.Suite.SuiteClasses;

@RunWith(Suite.class)
@SuiteClasses({ AQL2ExecutionTest.class, AQL2GenerationTest.class })
public class AllAQL2Tests {

}
