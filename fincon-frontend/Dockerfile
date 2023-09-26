# build stage
FROM node:lts-alpine as build-stage
RUN apk add g++ make py3-pip
WORKDIR /app
COPY package*.json ./
RUN npm install
COPY . .
RUN npm run build --configuration=production

# production stage
FROM nginx:stable-alpine as production-stage
COPY --from=build-stage /app/dist/fincon-frontend /usr/share/nginx/html
EXPOSE 80
CMD ["nginx", "-g", "daemon off;"]
