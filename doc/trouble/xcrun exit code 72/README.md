# `The /usr/bin/xcrun command returned non-zero exit code: 72.`

`iosXXX` 소스셋(Kotlin Native[^1])을 빌드하지 못 하는 문제.

KMM 샘플코드의 테스트를 실행하면 다음 에러가 발생한다.

```
e: Compilation failed: An error occurred during an xcrun execution. Make sure that Xcode and its command line tools are properly installed.
Failed command: /usr/bin/xcrun xcodebuild -version
Try running this command in Terminal and fix the errors by making Xcode (and its command line tools) configuration correct.
 * Source files: Platform.kt, Platform.ios.kt
 * Compiler version info: Konan: 1.8.21 / Kotlin: 1.8.21
 * Output kind: LIBRARY
e: org.jetbrains.kotlin.konan.MissingXcodeException: An error occurred during an xcrun execution. Make sure that Xcode and its command line tools are properly installed.
Failed command: /usr/bin/xcrun xcodebuild -version
Try running this command in Terminal and fix the errors by making Xcode (and its command line tools) configuration correct.
	at org.jetbrains.kotlin.konan.target.CurrentXcode.xcrun(Xcode.kt:116)
	at org.jetbrains.kotlin.konan.target.CurrentXcode.getXcodebuildVersion$StubGenerator(Xcode.kt:91)
	at org.jetbrains.kotlin.konan.target.CurrentXcode$version$2.invoke(Xcode.kt:101)
	at org.jetbrains.kotlin.konan.target.CurrentXcode$version$2.invoke(Xcode.kt:97)
	at kotlin.SynchronizedLazyImpl.getValue(LazyJVM.kt:74)
	at org.jetbrains.kotlin.konan.target.CurrentXcode.getVersion(Xcode.kt:97)
	at org.jetbrains.kotlin.konan.target.AppleConfigurablesImpl$xcodePartsProvider$2.invoke(Apple.kt:62)
	at org.jetbrains.kotlin.konan.target.AppleConfigurablesImpl$xcodePartsProvider$2.invoke(Apple.kt:54)
	at kotlin.SynchronizedLazyImpl.getValue(LazyJVM.kt:74)
	at org.jetbrains.kotlin.konan.target.AppleConfigurablesImpl.getXcodePartsProvider(Apple.kt:54)
	at org.jetbrains.kotlin.konan.target.AppleConfigurablesImpl.getDependencies(Apple.kt:49)
	at org.jetbrains.kotlin.konan.util.DependencyProcessor.<init>(DependencyProcessor.kt:125)
	at org.jetbrains.kotlin.konan.util.DependencyProcessor.<init>(DependencyProcessor.kt:117)
	at org.jetbrains.kotlin.konan.properties.KonanPropertiesLoader$dependencyProcessor$2.invoke(KonanProperties.kt:91)
	at org.jetbrains.kotlin.konan.properties.KonanPropertiesLoader$dependencyProcessor$2.invoke(KonanProperties.kt:89)
	at kotlin.SynchronizedLazyImpl.getValue(LazyJVM.kt:74)
	at org.jetbrains.kotlin.konan.properties.KonanPropertiesLoader.getDependencyProcessor(KonanProperties.kt:89)
	at org.jetbrains.kotlin.konan.properties.KonanPropertiesLoader.downloadDependencies(KonanProperties.kt:70)
	at org.jetbrains.kotlin.konan.target.Platform.downloadDependencies(Platform.kt)
	at org.jetbrains.kotlin.backend.konan.KonanConfig.<init>(KonanConfig.kt:199)
	at org.jetbrains.kotlin.backend.konan.KonanDriver.run(KonanDriver.kt:57)
	at org.jetbrains.kotlin.cli.bc.K2Native.runKonanDriver(K2Native.kt:133)
	at org.jetbrains.kotlin.cli.bc.K2Native.doExecute(K2Native.kt:70)
	at org.jetbrains.kotlin.cli.bc.K2Native.doExecute(K2Native.kt:36)
	at org.jetbrains.kotlin.cli.common.CLICompiler.execImpl(CLICompiler.kt:100)
	at org.jetbrains.kotlin.cli.common.CLICompiler.execImpl(CLICompiler.kt:46)
	at org.jetbrains.kotlin.cli.common.CLITool.exec(CLITool.kt:101)
	at org.jetbrains.kotlin.cli.common.CLITool.exec(CLITool.kt:79)
	at org.jetbrains.kotlin.cli.common.CLITool.exec(CLITool.kt:43)
	at org.jetbrains.kotlin.cli.common.CLITool$Companion.doMainNoExit(CLITool.kt:180)
	at org.jetbrains.kotlin.cli.bc.K2Native$Companion$mainNoExitWithRenderer$1.invoke(K2Native.kt:170)
	at org.jetbrains.kotlin.cli.bc.K2Native$Companion$mainNoExitWithRenderer$1.invoke(K2Native.kt:169)
	at org.jetbrains.kotlin.util.UtilKt.profileIf(Util.kt:22)
	at org.jetbrains.kotlin.util.UtilKt.profile(Util.kt:16)
	at org.jetbrains.kotlin.cli.bc.K2Native$Companion.mainNoExitWithRenderer(K2Native.kt:169)
	at org.jetbrains.kotlin.cli.bc.K2NativeKt.mainNoExitWithGradleRenderer(K2Native.kt:187)
	at org.jetbrains.kotlin.cli.utilities.MainKt$daemonMain$1.invoke(main.kt:51)
	at org.jetbrains.kotlin.cli.utilities.MainKt$daemonMain$1.invoke(main.kt:51)
	at org.jetbrains.kotlin.cli.utilities.MainKt.mainImpl(main.kt:20)
	at org.jetbrains.kotlin.cli.utilities.MainKt.inProcessMain(main.kt:58)
	at org.jetbrains.kotlin.cli.utilities.MainKt.daemonMain(main.kt:51)
	at java.base/jdk.internal.reflect.NativeMethodAccessorImpl.invoke0(Native Method)
	at java.base/jdk.internal.reflect.NativeMethodAccessorImpl.invoke(Unknown Source)
	at java.base/jdk.internal.reflect.DelegatingMethodAccessorImpl.invoke(Unknown Source)
	at java.base/java.lang.reflect.Method.invoke(Unknown Source)
	at org.jetbrains.kotlin.compilerRunner.KotlinToolRunner.runInProcess(KotlinToolRunner.kt:192)
	at org.jetbrains.kotlin.compilerRunner.KotlinToolRunner.run(KotlinToolRunner.kt:133)
	at org.jetbrains.kotlin.gradle.tasks.KotlinNativeCompile.compile(KotlinNativeTasks.kt:485)
	at java.base/jdk.internal.reflect.NativeMethodAccessorImpl.invoke0(Native Method)
	at java.base/jdk.internal.reflect.NativeMethodAccessorImpl.invoke(Unknown Source)
	at java.base/jdk.internal.reflect.DelegatingMethodAccessorImpl.invoke(Unknown Source)
	at java.base/java.lang.reflect.Method.invoke(Unknown Source)
	at org.gradle.internal.reflect.JavaMethod.invoke(JavaMethod.java:125)
	at org.gradle.api.internal.project.taskfactory.StandardTaskAction.doExecute(StandardTaskAction.java:58)
	at org.gradle.api.internal.project.taskfactory.StandardTaskAction.execute(StandardTaskAction.java:51)
	at org.gradle.api.internal.project.taskfactory.StandardTaskAction.execute(StandardTaskAction.java:29)
	at org.gradle.api.internal.tasks.execution.TaskExecution$3.run(TaskExecution.java:242)
	at org.gradle.internal.operations.DefaultBuildOperationRunner$1.execute(DefaultBuildOperationRunner.java:29)
	at org.gradle.internal.operations.DefaultBuildOperationRunner$1.execute(DefaultBuildOperationRunner.java:26)
	at org.gradle.internal.operations.DefaultBuildOperationRunner$2.execute(DefaultBuildOperationRunner.java:66)
	at org.gradle.internal.operations.DefaultBuildOperationRunner$2.execute(DefaultBuildOperationRunner.java:59)
	at org.gradle.internal.operations.DefaultBuildOperationRunner.execute(DefaultBuildOperationRunner.java:157)
	at org.gradle.internal.operations.DefaultBuildOperationRunner.execute(DefaultBuildOperationRunner.java:59)
	at org.gradle.internal.operations.DefaultBuildOperationRunner.run(DefaultBuildOperationRunner.java:47)
	at org.gradle.internal.operations.DefaultBuildOperationExecutor.run(DefaultBuildOperationExecutor.java:68)
	at org.gradle.api.internal.tasks.execution.TaskExecution.executeAction(TaskExecution.java:227)
	at org.gradle.api.internal.tasks.execution.TaskExecution.executeActions(TaskExecution.java:210)
	at org.gradle.api.internal.tasks.execution.TaskExecution.executeWithPreviousOutputFiles(TaskExecution.java:193)
	at org.gradle.api.internal.tasks.execution.TaskExecution.execute(TaskExecution.java:166)
	at org.gradle.internal.execution.steps.ExecuteStep.executeInternal(ExecuteStep.java:93)
	at org.gradle.internal.execution.steps.ExecuteStep.access$000(ExecuteStep.java:44)
	at org.gradle.internal.execution.steps.ExecuteStep$1.call(ExecuteStep.java:57)
	at org.gradle.internal.execution.steps.ExecuteStep$1.call(ExecuteStep.java:54)
	at org.gradle.internal.operations.DefaultBuildOperationRunner$CallableBuildOperationWorker.execute(DefaultBuildOperationRunner.java:204)
	at org.gradle.internal.operations.DefaultBuildOperationRunner$CallableBuildOperationWorker.execute(DefaultBuildOperationRunner.java:199)
	at org.gradle.internal.operations.DefaultBuildOperationRunner$2.execute(DefaultBuildOperationRunner.java:66)
	at org.gradle.internal.operations.DefaultBuildOperationRunner$2.execute(DefaultBuildOperationRunner.java:59)
	at org.gradle.internal.operations.DefaultBuildOperationRunner.execute(DefaultBuildOperationRunner.java:157)
	at org.gradle.internal.operations.DefaultBuildOperationRunner.execute(DefaultBuildOperationRunner.java:59)
	at org.gradle.internal.operations.DefaultBuildOperationRunner.call(DefaultBuildOperationRunner.java:53)
	at org.gradle.internal.operations.DefaultBuildOperationExecutor.call(DefaultBuildOperationExecutor.java:73)
	at org.gradle.internal.execution.steps.ExecuteStep.execute(ExecuteStep.java:54)
	at org.gradle.internal.execution.steps.ExecuteStep.execute(ExecuteStep.java:44)
	at org.gradle.internal.execution.steps.RemovePreviousOutputsStep.execute(RemovePreviousOutputsStep.java:67)
	at org.gradle.internal.execution.steps.RemovePreviousOutputsStep.execute(RemovePreviousOutputsStep.java:37)
	at org.gradle.internal.execution.steps.CancelExecutionStep.execute(CancelExecutionStep.java:41)
	at org.gradle.internal.execution.steps.TimeoutStep.executeWithoutTimeout(TimeoutStep.java:74)
	at org.gradle.internal.execution.steps.TimeoutStep.execute(TimeoutStep.java:55)
	at org.gradle.internal.execution.steps.CreateOutputsStep.execute(CreateOutputsStep.java:50)
	at org.gradle.internal.execution.steps.CreateOutputsStep.execute(CreateOutputsStep.java:28)
	at org.gradle.internal.execution.steps.CaptureStateAfterExecutionStep.executeDelegateBroadcastingChanges(CaptureStateAfterExecutionStep.java:100)
	at org.gradle.internal.execution.steps.CaptureStateAfterExecutionStep.execute(CaptureStateAfterExecutionStep.java:72)
	at org.gradle.internal.execution.steps.CaptureStateAfterExecutionStep.execute(CaptureStateAfterExecutionStep.java:50)
	at org.gradle.internal.execution.steps.ResolveInputChangesStep.execute(ResolveInputChangesStep.java:40)
	at org.gradle.internal.execution.steps.ResolveInputChangesStep.execute(ResolveInputChangesStep.java:29)
	at org.gradle.internal.execution.steps.BuildCacheStep.executeWithoutCache(BuildCacheStep.java:166)
	at org.gradle.internal.execution.steps.BuildCacheStep.lambda$execute$1(BuildCacheStep.java:70)
	at org.gradle.internal.Either$Right.fold(Either.java:175)
	at org.gradle.internal.execution.caching.CachingState.fold(CachingState.java:59)
	at org.gradle.internal.execution.steps.BuildCacheStep.execute(BuildCacheStep.java:68)
	at org.gradle.internal.execution.steps.BuildCacheStep.execute(BuildCacheStep.java:46)
	at org.gradle.internal.execution.steps.StoreExecutionStateStep.execute(StoreExecutionStateStep.java:36)
	at org.gradle.internal.execution.steps.StoreExecutionStateStep.execute(StoreExecutionStateStep.java:25)
	at org.gradle.internal.execution.steps.RecordOutputsStep.execute(RecordOutputsStep.java:36)
	at org.gradle.internal.execution.steps.RecordOutputsStep.execute(RecordOutputsStep.java:22)
	at org.gradle.internal.execution.steps.SkipUpToDateStep.executeBecause(SkipUpToDateStep.java:91)
	at org.gradle.internal.execution.steps.SkipUpToDateStep.lambda$execute$2(SkipUpToDateStep.java:55)
	at java.base/java.util.Optional.orElseGet(Unknown Source)
	at org.gradle.internal.execution.steps.SkipUpToDateStep.execute(SkipUpToDateStep.java:55)
	at org.gradle.internal.execution.steps.SkipUpToDateStep.execute(SkipUpToDateStep.java:37)
	at org.gradle.internal.execution.steps.ResolveChangesStep.execute(ResolveChangesStep.java:65)
	at org.gradle.internal.execution.steps.ResolveChangesStep.execute(ResolveChangesStep.java:36)
	at org.gradle.internal.execution.steps.legacy.MarkSnapshottingInputsFinishedStep.execute(MarkSnapshottingInputsFinishedStep.java:37)
	at org.gradle.internal.execution.steps.legacy.MarkSnapshottingInputsFinishedStep.execute(MarkSnapshottingInputsFinishedStep.java:27)
	at org.gradle.internal.execution.steps.ResolveCachingStateStep.execute(ResolveCachingStateStep.java:76)
	at org.gradle.internal.execution.steps.ResolveCachingStateStep.execute(ResolveCachingStateStep.java:37)
	at org.gradle.internal.execution.steps.ValidateStep.execute(ValidateStep.java:94)
	at org.gradle.internal.execution.steps.ValidateStep.execute(ValidateStep.java:49)
	at org.gradle.internal.execution.steps.CaptureStateBeforeExecutionStep.execute(CaptureStateBeforeExecutionStep.java:71)
	at org.gradle.internal.execution.steps.CaptureStateBeforeExecutionStep.execute(CaptureStateBeforeExecutionStep.java:45)
	at org.gradle.internal.execution.steps.SkipEmptyWorkStep.executeWithNonEmptySources(SkipEmptyWorkStep.java:177)
	at org.gradle.internal.execution.steps.SkipEmptyWorkStep.execute(SkipEmptyWorkStep.java:86)
	at org.gradle.internal.execution.steps.SkipEmptyWorkStep.execute(SkipEmptyWorkStep.java:53)
	at org.gradle.internal.execution.steps.RemoveUntrackedExecutionStateStep.execute(RemoveUntrackedExecutionStateStep.java:32)
	at org.gradle.internal.execution.steps.RemoveUntrackedExecutionStateStep.execute(RemoveUntrackedExecutionStateStep.java:21)
	at org.gradle.internal.execution.steps.legacy.MarkSnapshottingInputsStartedStep.execute(MarkSnapshottingInputsStartedStep.java:38)
	at org.gradle.internal.execution.steps.LoadPreviousExecutionStateStep.execute(LoadPreviousExecutionStateStep.java:36)
	at org.gradle.internal.execution.steps.LoadPreviousExecutionStateStep.execute(LoadPreviousExecutionStateStep.java:23)
	at org.gradle.internal.execution.steps.CleanupStaleOutputsStep.execute(CleanupStaleOutputsStep.java:75)
	at org.gradle.internal.execution.steps.CleanupStaleOutputsStep.execute(CleanupStaleOutputsStep.java:41)
	at org.gradle.internal.execution.steps.AssignWorkspaceStep.lambda$execute$0(AssignWorkspaceStep.java:32)
	at org.gradle.api.internal.tasks.execution.TaskExecution$4.withWorkspace(TaskExecution.java:287)
	at org.gradle.internal.execution.steps.AssignWorkspaceStep.execute(AssignWorkspaceStep.java:30)
	at org.gradle.internal.execution.steps.AssignWorkspaceStep.execute(AssignWorkspaceStep.java:21)
	at org.gradle.internal.execution.steps.IdentityCacheStep.execute(IdentityCacheStep.java:37)
	at org.gradle.internal.execution.steps.IdentityCacheStep.execute(IdentityCacheStep.java:27)
	at org.gradle.internal.execution.steps.IdentifyStep.execute(IdentifyStep.java:42)
	at org.gradle.internal.execution.steps.IdentifyStep.execute(IdentifyStep.java:31)
	at org.gradle.internal.execution.impl.DefaultExecutionEngine$1.execute(DefaultExecutionEngine.java:64)
	at org.gradle.api.internal.tasks.execution.ExecuteActionsTaskExecuter.executeIfValid(ExecuteActionsTaskExecuter.java:146)
	at org.gradle.api.internal.tasks.execution.ExecuteActionsTaskExecuter.execute(ExecuteActionsTaskExecuter.java:135)
	at org.gradle.api.internal.tasks.execution.FinalizePropertiesTaskExecuter.execute(FinalizePropertiesTaskExecuter.java:46)
	at org.gradle.api.internal.tasks.execution.ResolveTaskExecutionModeExecuter.execute(ResolveTaskExecutionModeExecuter.java:51)
	at org.gradle.api.internal.tasks.execution.SkipTaskWithNoActionsExecuter.execute(SkipTaskWithNoActionsExecuter.java:57)
	at org.gradle.api.internal.tasks.execution.SkipOnlyIfTaskExecuter.execute(SkipOnlyIfTaskExecuter.java:74)
	at org.gradle.api.internal.tasks.execution.CatchExceptionTaskExecuter.execute(CatchExceptionTaskExecuter.java:36)
	at org.gradle.api.internal.tasks.execution.EventFiringTaskExecuter$1.executeTask(EventFiringTaskExecuter.java:77)
	at org.gradle.api.internal.tasks.execution.EventFiringTaskExecuter$1.call(EventFiringTaskExecuter.java:55)
	at org.gradle.api.internal.tasks.execution.EventFiringTaskExecuter$1.call(EventFiringTaskExecuter.java:52)
	at org.gradle.internal.operations.DefaultBuildOperationRunner$CallableBuildOperationWorker.execute(DefaultBuildOperationRunner.java:204)
	at org.gradle.internal.operations.DefaultBuildOperationRunner$CallableBuildOperationWorker.execute(DefaultBuildOperationRunner.java:199)
	at org.gradle.internal.operations.DefaultBuildOperationRunner$2.execute(DefaultBuildOperationRunner.java:66)
	at org.gradle.internal.operations.DefaultBuildOperationRunner$2.execute(DefaultBuildOperationRunner.java:59)
	at org.gradle.internal.operations.DefaultBuildOperationRunner.execute(DefaultBuildOperationRunner.java:157)
	at org.gradle.internal.operations.DefaultBuildOperationRunner.execute(DefaultBuildOperationRunner.java:59)
	at org.gradle.internal.operations.DefaultBuildOperationRunner.call(DefaultBuildOperationRunner.java:53)
	at org.gradle.internal.operations.DefaultBuildOperationExecutor.call(DefaultBuildOperationExecutor.java:73)
	at org.gradle.api.internal.tasks.execution.EventFiringTaskExecuter.execute(EventFiringTaskExecuter.java:52)
	at org.gradle.execution.plan.LocalTaskNodeExecutor.execute(LocalTaskNodeExecutor.java:42)
	at org.gradle.execution.taskgraph.DefaultTaskExecutionGraph$InvokeNodeExecutorsAction.execute(DefaultTaskExecutionGraph.java:338)
	at org.gradle.execution.taskgraph.DefaultTaskExecutionGraph$InvokeNodeExecutorsAction.execute(DefaultTaskExecutionGraph.java:325)
	at org.gradle.execution.taskgraph.DefaultTaskExecutionGraph$BuildOperationAwareExecutionAction.execute(DefaultTaskExecutionGraph.java:318)
	at org.gradle.execution.taskgraph.DefaultTaskExecutionGraph$BuildOperationAwareExecutionAction.execute(DefaultTaskExecutionGraph.java:304)
	at org.gradle.execution.plan.DefaultPlanExecutor$ExecutorWorker.execute(DefaultPlanExecutor.java:463)
	at org.gradle.execution.plan.DefaultPlanExecutor$ExecutorWorker.run(DefaultPlanExecutor.java:380)
	at org.gradle.internal.concurrent.ExecutorPolicy$CatchAndRecordFailures.onExecute(ExecutorPolicy.java:64)
	at org.gradle.internal.concurrent.ManagedExecutorImpl$1.run(ManagedExecutorImpl.java:49)
	at java.base/java.util.concurrent.ThreadPoolExecutor.runWorker(Unknown Source)
	at java.base/java.util.concurrent.ThreadPoolExecutor$Worker.run(Unknown Source)
	at java.base/java.lang.Thread.run(Unknown Source)
Caused by: org.jetbrains.kotlin.konan.KonanExternalToolFailure: The /usr/bin/xcrun command returned non-zero exit code: 72.
output:
	at org.jetbrains.kotlin.konan.exec.Command.handleExitCode(ExecuteCommand.kt:123)
	at org.jetbrains.kotlin.konan.exec.Command.getResult(ExecuteCommand.kt:112)
	at org.jetbrains.kotlin.konan.exec.Command.getOutputLines(ExecuteCommand.kt:87)
	at org.jetbrains.kotlin.konan.exec.Command.getOutputLines$default(ExecuteCommand.kt:86)
	at org.jetbrains.kotlin.konan.target.CurrentXcode.xcrun(Xcode.kt:106)
	... 169 more
```

## `kdoctor` 상태

Xcode의 커맨드 라인 툴 설치를 인식하지 못 한다.

```
➜  kmm git:(issue/8-xcrun_72_error) kdoctor
Environment diagnose (to see all details, use -v option):
[✓] Operation System
[✓] Java
[✓] Android Studio
[✖] Xcode
  ✖ Current command line tools: /Library/Developer/CommandLineTools
    You have to select command line tools bundled to Xcode
    Command line tools can be configured in Xcode -> Settings -> Locations -> Locations
[✖] Cocoapods
  ✖ cocoapods not found
    Get cocoapods from https://guides.cocoapods.org/using/getting-started.html#installation

Conclusion:
  ✖ KDoctor has diagnosed one or more problems while checking your environment.
    Please check the output for problem description and possible solutions.
```

## Xcode 설정

Xcode 설정 열기. (Xcode -> Settings -> Locations -> Locations)

![Xcode 설정 위치](xcode%20preferences.png)

Command line Tools 드랍다운 선택하면 인증창 나옴.

![command line tools.png](command%20line%20tools.png)

설정된 Command Line Tools 경로.

![command line tools setted.png](command%20line%20tools%20setted.png)

정상적인 `kdoctor` 결과.

```
➜  kmm git:(issue/8-xcrun_72_error) kdoctor
Environment diagnose (to see all details, use -v option):
[✓] Operation System
[✓] Java
[✓] Android Studio
[✓] Xcode
[✖] Cocoapods
  ✖ cocoapods not found
    Get cocoapods from https://guides.cocoapods.org/using/getting-started.html#installation

Conclusion:
  ✖ KDoctor has diagnosed one or more problems while checking your environment.
    Please check the output for problem description and possible solutions.
```

## 확인

1. [`./gradlew :shared:check --continue`](./../../../.run/_shared%20%5Bcheck%5D.run.xml) 실행.
2. `BUILD SUCCESSFUL in ...` 메시지가 나오면 성공.

```
> Configure project :shared
w: Kotlin Multiplatform <-> Android Gradle Plugin compatibility issue: The applied Android Gradle Plugin version (8.1.1) is higher than the maximum known to the Kotlin Gradle Plugin. Tooling stability in such configuration isn't tested, please report encountered issues to https://kotl.in/issue
Minimum supported Android Gradle Plugin version: 4.1
Maximum tested Android Gradle Plugin version: 8.0
To suppress this message add 'kotlin.mpp.androidGradlePluginCompatibility.nowarn=true' to your gradle.properties


> Task :shared:compileKotlinIosSimulatorArm64 UP-TO-DATE
> Task :shared:iosSimulatorArm64ProcessResources NO-SOURCE
> Task :shared:iosSimulatorArm64MainKlibrary UP-TO-DATE
> Task :shared:compileTestKotlinIosSimulatorArm64 NO-SOURCE
> Task :shared:linkDebugTestIosSimulatorArm64 NO-SOURCE
> Task :shared:iosSimulatorArm64Test SKIPPED
> Task :shared:compileKotlinIosX64 UP-TO-DATE
> Task :shared:iosX64ProcessResources NO-SOURCE
> Task :shared:iosX64MainKlibrary UP-TO-DATE
> Task :shared:compileTestKotlinIosX64 NO-SOURCE
> Task :shared:linkDebugTestIosX64 NO-SOURCE
> Task :shared:iosX64Test SKIPPED
> Task :shared:preBuild UP-TO-DATE
> Task :shared:preDebugBuild UP-TO-DATE
> Task :shared:generateDebugResValues UP-TO-DATE
> Task :shared:generateDebugResources UP-TO-DATE
> Task :shared:packageDebugResources UP-TO-DATE
> Task :shared:parseDebugLocalResources UP-TO-DATE
> Task :shared:processDebugManifest UP-TO-DATE
> Task :shared:generateDebugRFile UP-TO-DATE
> Task :shared:compileDebugKotlinAndroid UP-TO-DATE
> Task :shared:javaPreCompileDebug UP-TO-DATE
> Task :shared:compileDebugJavaWithJavac NO-SOURCE
> Task :shared:bundleLibRuntimeToJarDebug UP-TO-DATE
> Task :shared:bundleLibCompileToJarDebug UP-TO-DATE
> Task :shared:preDebugUnitTestBuild UP-TO-DATE
> Task :shared:generateDebugUnitTestStubRFile UP-TO-DATE
> Task :shared:compileDebugUnitTestKotlinAndroid NO-SOURCE
> Task :shared:javaPreCompileDebugUnitTest UP-TO-DATE
> Task :shared:compileDebugUnitTestJavaWithJavac NO-SOURCE
> Task :shared:processDebugJavaRes UP-TO-DATE
> Task :shared:processDebugUnitTestJavaRes NO-SOURCE
> Task :shared:testDebugUnitTest NO-SOURCE
> Task :shared:preReleaseBuild UP-TO-DATE
> Task :shared:generateReleaseResValues UP-TO-DATE
> Task :shared:generateReleaseResources UP-TO-DATE
> Task :shared:packageReleaseResources UP-TO-DATE
> Task :shared:parseReleaseLocalResources UP-TO-DATE
> Task :shared:processReleaseManifest UP-TO-DATE
> Task :shared:generateReleaseRFile UP-TO-DATE
> Task :shared:compileReleaseKotlinAndroid UP-TO-DATE
> Task :shared:javaPreCompileRelease UP-TO-DATE
> Task :shared:compileReleaseJavaWithJavac NO-SOURCE
> Task :shared:bundleLibRuntimeToJarRelease UP-TO-DATE
> Task :shared:bundleLibCompileToJarRelease UP-TO-DATE
> Task :shared:preReleaseUnitTestBuild UP-TO-DATE
> Task :shared:generateReleaseUnitTestStubRFile UP-TO-DATE
> Task :shared:compileReleaseUnitTestKotlinAndroid NO-SOURCE
> Task :shared:javaPreCompileReleaseUnitTest UP-TO-DATE
> Task :shared:compileReleaseUnitTestJavaWithJavac NO-SOURCE
> Task :shared:processReleaseJavaRes UP-TO-DATE
> Task :shared:processReleaseUnitTestJavaRes NO-SOURCE
> Task :shared:testReleaseUnitTest NO-SOURCE
> Task :shared:allTests NO-SOURCE
> Task :shared:mergeDebugJniLibFolders UP-TO-DATE
> Task :shared:mergeDebugNativeLibs NO-SOURCE
> Task :shared:stripDebugDebugSymbols NO-SOURCE
> Task :shared:copyDebugJniLibsProjectAndLocalJars UP-TO-DATE
> Task :shared:extractDebugAnnotations UP-TO-DATE
> Task :shared:extractDeepLinksForAarDebug UP-TO-DATE
> Task :shared:mergeDebugGeneratedProguardFiles UP-TO-DATE
> Task :shared:mergeDebugConsumerProguardFiles UP-TO-DATE
> Task :shared:mergeDebugShaders UP-TO-DATE
> Task :shared:compileDebugShaders NO-SOURCE
> Task :shared:generateDebugAssets UP-TO-DATE
> Task :shared:packageDebugAssets UP-TO-DATE
> Task :shared:prepareDebugArtProfile UP-TO-DATE
> Task :shared:prepareLintJarForPublish UP-TO-DATE
> Task :shared:mergeDebugJavaResource UP-TO-DATE
> Task :shared:syncDebugLibJars UP-TO-DATE
> Task :shared:writeDebugAarMetadata UP-TO-DATE
> Task :shared:bundleDebugLocalLintAar UP-TO-DATE
> Task :shared:createFullJarDebug UP-TO-DATE
> Task :shared:extractProguardFiles UP-TO-DATE
> Task :shared:preDebugAndroidTestBuild UP-TO-DATE
> Task :shared:generateDebugAndroidTestResValues UP-TO-DATE
> Task :shared:writeDebugLintModelMetadata UP-TO-DATE
> Task :shared:lintAnalyzeDebug UP-TO-DATE
> Task :shared:lintReportDebug UP-TO-DATE
> Task :shared:lintDebug
> Task :shared:lint
> Task :shared:test UP-TO-DATE
> Task :shared:check

BUILD SUCCESSFUL in 1s
47 actionable tasks: 1 executed, 46 up-to-date
```

## 참고

[^1]: [Kotlin Native](https://kotlinlang.org/docs/native-overview.html)
