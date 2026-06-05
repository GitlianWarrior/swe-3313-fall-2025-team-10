# Free Deployment Guide

This project is a Spring Boot web app located in `source/rare-cars-sales`. The app uses PostgreSQL in `application.properties`, so a free deployment needs two services:

- a free web service to run the Spring Boot app
- a free PostgreSQL database

The recommended setup is Render for the web service and Neon for PostgreSQL.

## 1. Create a Free Neon Database

1. Create a Neon account at <https://neon.com>.
2. Create a new project.
3. Open the connection details for the database.
4. Copy these values:
   - host
   - database name
   - username
   - password

Render needs the values in this format:

```text
DATABASE_URL=jdbc:postgresql://YOUR_NEON_HOST/YOUR_DATABASE_NAME?sslmode=require
DATABASE_USERNAME=YOUR_NEON_USERNAME
DATABASE_PASSWORD=YOUR_NEON_PASSWORD
```

Do not commit those values to GitHub.

## 2. Deploy the Web App on Render

1. Create a Render account at <https://render.com>.
2. Select **New > Blueprint**.
3. Connect this GitHub repository.
4. Render will read `render.yaml`.
5. When Render asks for environment variables, paste:
   - `DATABASE_URL`
   - `DATABASE_USERNAME`
   - `DATABASE_PASSWORD`
6. Use the Free instance type.
7. Start the deploy.

The Render service builds from `source/rare-cars-sales/Dockerfile`. The app listens on the `PORT` environment variable when Render provides one.

## 3. Test the Deployed Site

After Render finishes, open the generated `onrender.com` URL.

Sample login accounts from the seed data:

| Username | Password |
| --- | --- |
| `admin` | `admin123` |
| `user` | `user123` |

These demo credentials are public and should not be used for a production deployment.

## Free Tier Notes

- Render Free web services spin down after a period of no traffic and can take about a minute to wake up.
- Render Free web services have an ephemeral filesystem, so local SQLite files or uploaded files will not persist.
- Neon Free is enough for a small class/demo project, but the database may sleep when inactive.
- Keep the database credentials in Render environment variables only.
