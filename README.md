# Chattr - Scalable Real-Time Chat & Video Application (In Progress)

**Chattr** is a real-time messaging and video chat platform designed to scale.  

It enables users to connect for casual conversations, friendships, or romantic chats — blending the best of WhatsApp, Discord, Omegle, and Tinder.

Built using a distributed microservices architecture in **Spring Boot**, Chattr is a backend-focused project designed to master **system design**, **distributed systems**, and **cloud-native development**.

---

## Project Goals 
- Build a real-time platform with chat, calling, and media features
- Implement **random user matching** (like Omegle/Tinder)
- Explore **modern distributed system design** at scale
- Master principles of:
  - Microservices
  - Event-driven architecture
  - gRPC + WebSockets
  - Observability + CI/CD

---

## Core Features

- JWT-based user authentication (OAuth2 planned)
- Real-time 1-on-1 chat (WebSocket + Redis)
- Random user matching (friend, casual, romantic)
- Presence tracking (online, last seen)
- WebRTC audio + video calls
- Media sharing (images, videos, voice notes)
- Swipe-based user discovery
- Push notifications (mobile/web)
- Moderation tools (report/block)
- Group chat support
- Analytics + usage tracking

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

## Why This Project?

Chattr is more than a chat app — it’s a system design playground that touches:

	•	Authentication
	•	Realtime systems
	•	Horizontal scaling
	•	Queues, pub/sub
	•	CI/CD and observability
