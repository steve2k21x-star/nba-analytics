# nba-analytics
nba analytics system using Python, Java, SQL, JavaScript, and HTML.

- Python ETL: fetches NBA data, computes advanced metrics, loads PostgreSQL
- Java backend (Spring Boot): REST APIs for team KPIs and player metrics
- SQL: schema, views, and stored procedures for analytics
- JS + HTML dashboard: visualizes team net rating and top players

## Quick start (with Docker)

```bash
docker-compose up --build


---

### docker-compose.yml

```yaml
version: "3.9"

services:
  db:
    image: postgres:15
    environment:
      POSTGRES_USER: nba_user
      POSTGRES_PASSWORD: nba_pass
      POSTGRES_DB: nba_db
    ports:
      - "5432:5432"
    volumes:
      - db_data:/var/lib/postgresql/data
      - ./sql/init_db.sql:/docker-entrypoint-initdb.d/init_db.sql

  python-etl:
    build: ./python-etl
    environment:
      DATABASE_URL: postgresql://nba_user:nba_pass@db:5432/nba_db
    depends_on:
      - db

  java-backend:
    build: ./java-backend
    environment:
      SPRING_DATASOURCE_URL: jdbc:postgresql://db:5432/nba_db
      SPRING_DATASOURCE_USERNAME: nba_user
      SPRING_DATASOURCE_PASSWORD: nba_pass
    depends_on:
      - db
    ports:
      - "8080:8080"

  web-dashboard:
    image: nginx:alpine
    volumes:
      - ./web-dashboard:/usr/share/nginx/html:ro
    ports:
      - "8081:80"
    depends_on:
      - java-backend

volumes:
  db_data:

