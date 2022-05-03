FROM node:17-alpine3.14

ENV MONGO_DB_USERNAME=admin \
    MONGO_DB_PASSWORD=vikas

RUN mkdir -p /home/app

COPY ./app /home/app

CMD ["node", "/home/app/server.js"]
