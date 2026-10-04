# Valorant Coach

A Java-based coaching tool that helps Valorant players rank up by analysing their aim, deaths and agent performance.

> Status: early development. Not affiliated with or endorsed by Riot Games.

## Goals

- **Aim analysis** – find out where your aim fails (reaction time, flick accuracy, micro-adjustments, tracking, consistency).
- **Death analysis** – when and how you die (early in the round, alone, after the plant, ...).
- **Agent analysis** – which agents and maps work best for you.
- **Training plan** – concrete routines and fixes based on your weaknesses.
- **Accounts** – user login so progress is saved over time.

## Planned metrics (aim)

| Metric | Description |
|---|---|
| Reaction time | Time from target appearing to first mouse movement and to the click |
| Flick accuracy | Overshoot / undershoot of the first flick |
| Micro-adjustments | Number and duration of corrections after the first flick |
| Tracking smoothness | Jitter and deviation while following a moving target |
| Consistency | Standard deviation of all values above |
| Fatigue | Performance drop over the length of a session |

## Project structure

```
valorant-coach/
├── core/        # Analysis logic (no UI, no web) – we start here
├── riot-client/ # (planned) Riot API integration
├── backend/     # (planned) Spring Boot, login, database
└── ui/          # (planned) Web or JavaFX frontend
```

## Requirements

- JDK 21
- Maven 3.9+

## Build and test

```bash
mvn clean verify
```

## Secrets

Never commit API keys. Keep them in environment variables or in a local file that is listed in `.gitignore`
(for example `application-local.properties`).

## Roadmap

- [ ] Data models for aim events
- [ ] Reaction time calculation
- [ ] Flick accuracy and micro-adjustments
- [ ] Weakness score per category
- [ ] Own aim test that records mouse data
- [ ] Riot API client (needs an approved production key)
- [ ] Backend with login
- [ ] UI

## Contributing

See [CONTRIBUTING.md](CONTRIBUTING.md).
