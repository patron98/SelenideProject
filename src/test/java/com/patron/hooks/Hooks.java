package com.patron.hooks;

import io.cucumber.java.After;

public class Hooks {
    @After("@CleanupScenario")
    public void cleanupAfterScenario() {

    }
}
