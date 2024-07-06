package com.javawiz.command;

import lombok.extern.slf4j.Slf4j;
import org.buildobjects.process.ExternalProcessFailureException;
import org.buildobjects.process.ProcBuilder;
import org.buildobjects.process.ProcResult;
import org.buildobjects.process.StartupException;
import org.buildobjects.process.TimeoutException;

@Slf4j
public class CommandLine {
    public static final String ERROR_RUNNING_COMMAND_S = "Error running command %s";

    public ProcResult run(String command, String... args) {
        try {
            log.info("running command {} with args {}...", command, args);
            ProcResult result = new ProcBuilder(command)
                .withArgs(args)
                .withArg("--tfstate")
                .withArg("sample.tf")
                //.withArg("--username qi-readonly@vsphere.local")
                .withExpectedExitStatuses(0)
                .withNoTimeout()
                .run();
            if (result.getExitValue() == 0) {
                log.info("run command {} with args {} - finished", command, args);
                return result;
            }
            log.error("error running command {} with exit code {} and message {}", command, result.getExitValue(), result.getErrorString());
            throw new RuntimeException(String.format(ERROR_RUNNING_COMMAND_S, command));
        } catch (StartupException | TimeoutException | ExternalProcessFailureException e) {
            log.error("Error managing command line", e);
            throw new RuntimeException(String.format(ERROR_RUNNING_COMMAND_S, command));
        }
    }

    public static void main(String[] args) {
        CommandLine commandLine = new CommandLine();
        commandLine.run("C:/dev/qi-service/windows/terracognita-windows-amd64.exe",
                        "vsphere"
                        //"vsphere --vsphereserver 10.254.4.67 --username qi-readonly@vsphere.local --password cpt}bORS1SmIpOI$ --tfstate a.tf --soap-url 10.254.4.67 -i vsphere_compute_cluster"
        );
    }

}
