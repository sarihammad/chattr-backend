# Chattr - Scalable Real-Time Chat & Video Application (In Progress)

**Chattr** is a real-time messaging and video chat platform designed to scale.  

It enables users to connect for casual conversations, friendships, or romantic chats — blending the best of WhatsApp, Discord, Omegle, and Tinder.

Built using a distributed microservices architecture in **Spring Boot**, Chattr is a backend-focused project designed to master **system design**, **distributed systems**, and **cloud-native development**.

---

## Project Outline 
- Build a **WhatsApp-like app** with messaging, calling, and media features.
- Add **random user matching** functionality (like Omegle/Tinder).
- Explore **distributed system design** in depth.
- Use modern architectural principles: **microservices**, **event-driven**, **gRPC**, **horizontal scaling**.

---

## Features

- User registration & login (JWT based)
- Real-time text chat (1-on-1)
- Random user matching engine (casual/friend/romantic)
- Online/offline presence tracking
- Group chats
- Audio & video calls (via WebRTC)
- End-to-end encrypted messages
- Profile discovery & swipe-based matching
- Push notifications
- Media sharing (images, voice notes, videos)
- Moderation tools (report/block)
- Analytics and usage tracking

---

## Microservices Architecture

| Service | Responsibilities |
|--------|------------------|
| `gateway-service` | API gateway, routing, rate limiting, JWT filtering |
| `auth-service` | User authentication (JWT, OAuth2), token issuing |
| `user-service` | User profiles, preferences, updates |
| `chat-service` | Messaging engine, message persistence, WebSocket support |
| `matchmaking-service` | User matching logic (random pairing based on preferences) |
| `presence-service` | Real-time presence tracking (online/offline/last seen) |
| `notification-service` | Push notifications, in-app alerts |
| `call-service` | WebRTC signaling, session management |
| `media-service` | Upload and serve media (images/audio/video) |
| `moderation-service` | User reporting, blocking, content flagging |
| `friendship-service` | Friend requests, block lists |
| `analytics-service` | User interaction/event tracking |
| `shared-library` | Common DTOs, gRPC clients, utilities |

---

## Monorepo Directory Structure

```bash
chattr-backend/
├── gateway-service/
├── auth-service/
├── user-service/
├── chat-service/
├── matchmaking-service/
├── presence-service/
├── call-service/
├── media-service/
├── notification-service/
├── moderation-service/
├── friendship-service/
├── analytics-service/
├── shared-library/
├── docker/               
├── k8s/                  # Kubernetes manifests (future)
└── docs/                 # Architecture diagrams and specs
```

---

## Tech Stack

| Layer | Tools |
|------|-------|
| **Backend** | Spring Boot, Spring Cloud, Spring Security |
| **API Gateway** | Spring Cloud Gateway |
| **Auth** | JWT, OAuth2 |
| **Async Messaging** | Apache Kafka |
| **Service Discovery** | Eureka or Consul |
| **Realtime** | WebSocket (STOMP), Redis Pub/Sub |
| **Inter-Service** | gRPC |
| **Databases** | PostgreSQL, Cassandra, Redis |
| **Media Storage** | MinIO or AWS S3 |
| **Containerization** | Docker, Docker Compose |
| **Observability** | Prometheus, Grafana, Zipkin |

---

## Communication Patterns

- **Gateway → Services**: REST with JWT
- **Internal Services**: gRPC for low-latency calls
- **Chat Delivery & Events**: Kafka (async pub-sub)
- **Realtime**: WebSocket + Redis Pub/Sub

---

## Deployment Strategy

- Local dev: Docker Compose with all services
- Production: Kubernetes with Helm (future)
- CI/CD: GitHub Actions for build/test/deploy

---

## Security Considerations

- JWT-based stateless auth across all services
- OAuth2 login support (Google, Facebook)
- Input validation & sanitization
- Optional end-to-end encryption for messages

---

## Observability

- Metrics: Prometheus + Grafana
- Logs: Centralized logging (ELK or Loki)
- Tracing: Zipkin/Jaeger for distributed tracing
