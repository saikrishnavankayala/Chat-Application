# Chat Application

A real-time chat application built using **Java Sockets** with a client-server architecture. It supports multiple clients for seamless communication using multithreading.

## Features
- 📡 Real-time messaging using **Sockets**
- 👥 Supports **multiple clients** simultaneously
- ⚡ Efficient server management with **Multithreading**
- 🖥️ Optional **GUI with Swing** for a user-friendly interface
- 🛡️ Secure connection handling

## Technology Stack
- **Java** - Core programming language
- **Sockets** - Network communication
- **Multithreading** - For concurrent connections
- **Swing (Optional)** - GUI-based chat window

## How It Works
1. **Server:** Listens for incoming client connections.
2. **Clients:** Connect to the server using sockets.
3. **Communication:** Messages are relayed in real time to all connected clients using broadcast messaging.
4. **Multithreading:** Each client has a dedicated thread for handling communication.

## Setup and Run
1. Clone the repository:
    ```bash
    git clone https://github.com/your-username/Chat-Application.git
    ```
2. Navigate to the project directory:
    ```bash
    cd Chat-Application
    ```
3. Compile the Java files:
    ```bash
    javac Server.java Client.java
    ```
4. Run the server:
    ```bash
    java Server
    ```
5. Run the client(s):
    ```bash
    java Client
    ```

## Future Enhancements
- 🔒 Implement **message encryption** for secure communication.
- 🆔 Add **user authentication** for personalized chat rooms.
- 🗂️ Store chat history using a **database**.

---

**Contributions are welcome!**  
Feel free to fork the repository, make changes, and submit a pull request.  

📧 For any queries, contact: **saikrishnavankayala9@gmail.com**  
