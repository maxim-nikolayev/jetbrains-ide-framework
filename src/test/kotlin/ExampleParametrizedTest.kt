import builder.TestContextBuilder
import com.intellij.driver.client.Driver
import com.intellij.driver.client.service
import com.intellij.driver.sdk.getOpenProjects
import com.intellij.driver.sdk.invokeAction
import com.intellij.driver.sdk.openFile
import com.intellij.driver.sdk.ui.components.*
import com.intellij.driver.sdk.ui.shouldHave
import com.intellij.driver.sdk.ui.ui
import com.intellij.driver.sdk.waitForIndicators
import com.intellij.ide.starter.driver.engine.runIdeWithDriver
import com.intellij.ide.starter.driver.execute
import com.intellij.ide.ui.LafManager
import com.intellij.openapi.command.executeCommand
import com.intellij.terminal.TerminalUtils
import com.intellij.tools.ide.performanceTesting.commands.*
import org.junit.jupiter.api.Assertions
import org.junit.jupiter.api.Test
import org.junit.jupiter.params.ParameterizedTest
import org.junit.jupiter.params.provider.CsvSource
import kotlin.time.Duration.Companion.minutes

class ExampleParametrizedTest {

    @ParameterizedTest
    @CsvSource(
        "IC, Stirling-Tools/Stirling-PDF, main, 2024.3",
        "WS, Mintplex-Labs/anything-llm, master, 2024.3"
    )
    fun exampleParametrizedTest(ide: String,
                                repo: String,
                                branch: String,
                                ideVersion: String) {
        TestContextBuilder()
            .withIde(ide)
            .withRepository(repo)
            .withBranch(branch)
            .withIDEVersion(ideVersion)
            .build()


        .runIdeWithDriver().useDriverAndCloseIde {
                waitForIndicators(5.minutes)
                openFile("SECURITY.md")

                ideFrame {
                    editor {
                        keyboard {
                        enterText("THIS IS A TEST")
                        }
                    }

                   keyboard {
                      hotKey(18, 123)
                   }
                    terminalToolWindow {
                        keyboard {
                            enterText("git --help")
                            enter()
                        }
                    }

                    keyboard {
                        hotKey(17, 16, 70)
                    }

                    searchEverywherePopup {
                        keyboard {
                            enterText("THIS IS A TEST") }
                    }
                }
        }
    }
}




