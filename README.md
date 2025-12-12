# Library Management System - Architecture Comparison

This project implements a minimal Library Management System to compare two architectural styles: a Layered Architecture and a simulated Microservices Architecture. Both versions implement the same CRUD-based domain (books, users, loans) to highlight architectural trade-offs.

## Features
- Create, view, update, delete books (CRUD)
- Check availability
- Create and list loans

## Implemented Architectures

### 1) Layered Architecture (recommended)
A single structured application with:
Presentation → Application → Business → Persistence → Database

**Pros**
- Low infrastructure overhead  
- Simple ACID transactions  
- Easy testing and debugging  
- Fast development, clear structure  

**Cons**
- Monolithic deployment  
- Can grow tightly coupled without proper modularization  

### 2) Microservices Architecture (simulated)
Separated services:
- book-service  
- user-service  
- loan-service  

**Pros**
- Clear domain boundaries  
- Independent scaling and deployment  
- Strong API and resilience mindset  

**Cons**
- Higher complexity (network, infra, monitoring)  
- Harder data consistency  
- More complex testing/debugging  
- Overengineering for a small CRUD system  

## Conclusion
For a CRUD-focused library domain, a Layered Architecture offers the best balance of simplicity, maintainability, and reliability. Microservices illustrate useful concepts but do not provide real benefits at this scale.
