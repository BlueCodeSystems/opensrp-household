# Changelog

All notable changes to this project will be documented in this file.

## [2.1.2] - 2025-10-01

### Bug Fixes
- Restore legacy drawable aliases and add missing compatibility assets so legacy clients continue resolving shared resources correctly.

### Maintenance
- Update repository naming to consistently reference `opensrp-household`.

## [2.1.1] - 2025-09-12

### Changed
- Update artifact ID in gradle.properties to `opensrp-household` for publishing alignment.

## [2.1.0] - 2025-09-11

### Added
- GitHub Action to maintain JitPack badges and proactively trigger master builds.
- JitPack configuration to build with JDK 17 and Android SDK 35 and publish to local Maven on CI.
- Publishing helpers (maven.gradle) with Central bundle (checksums/zip) and signing support.

### Changed
- Migrate library and sample to Android Gradle Plugin 8.6.0 and Gradle 8.7.
- Target Android SDK 35 (compile/target), minSdk 28, build-tools 35.0.0.
- Switch consumption docs from GitHub Packages to JitPack.
- Modernize packaging and lint configuration; add Jacoco 0.8.10 reports.

### Fixed
- Align json-wizard integration by removing legacy `Form` extras and using supported APIs.
- Simplify JitPack YAML to avoid parsing errors.
- Update AndroidX test APIs for instrumentation tests.

### Tests
- Harden unit tests for JDK 17 (Robolectric config, remove PowerMock ignore).
- Add robolectric.properties and conservative JVM `--add-opens` for test tasks.

### Dependencies
- OpenSRP core routed to JitPack: `com.github.BlueCodeSystems:opensrp-client-core:v6.2.2`.
- Native form: `io.github.bluecodesystems:opensrp-client-native-form-new:3.1.3`.
- Utils: `io.github.bluecodesystems:opensrp-client-utils:0.0.6`.
- Configurable views: `com.github.BlueCodeSystems:opensrp-client-configurable-views:v2.0.1`.
- Guava `32.1.3-android`, EventBus `3.3.1`.

### CI/CD
- Add managed badge block to README with Latest, latest tag, and master-SNAPSHOT JitPack badges.

---

## [2.0.2-SNAPSHOT] - 2025-??-??
- Previous snapshot (tagged) prior to the toolchain upgrade.
