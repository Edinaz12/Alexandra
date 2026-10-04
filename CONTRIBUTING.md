# Contributing

Rules for working together in this repository. Everything (code, comments, commits, issues, pull requests) is written in **English**.

## Workflow

1. Never push directly to `main`.
2. Create a branch from an up-to-date `main`:
   - `feature/<short-name>` for new functionality, e.g. `feature/aim-reaction-time`
   - `fix/<short-name>` for bug fixes
   - `docs/<short-name>` for documentation
3. Commit small and often.
4. Open a pull request into `main`. The other person reviews it before it is merged.
5. Delete the branch after merging.

## Commit messages

Short, English, imperative mood, no trailing period:

```
Add reaction time calculation
Fix division by zero in flick accuracy
```

## Code style

- Java 21
- 4 spaces indentation, no tabs
- Classes `PascalCase`, methods and variables `camelCase`, constants `UPPER_SNAKE_CASE`
- Every public class and method gets a short Javadoc comment
- Every calculation gets a unit test (JUnit 5)

## Secrets

Never commit API keys, passwords or tokens. Use environment variables or a local file that is listed in `.gitignore`.
If a secret is committed by accident, revoke it immediately and tell the other person.

## Before opening a pull request

```bash
mvn clean verify
```

The build and all tests must pass.
