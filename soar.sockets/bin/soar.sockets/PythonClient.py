import socket

encoding = "utf-8"

# Create a client socket
clientSocket = socket.socket()

# Connect to the Java server socket
clientSocket.connect(("localhost", 8000))

# Send the message
clientSocket.send(bytes("YO10 5AW"))

# Receive the response
response = clientSocket.recv(1024)

# Print the response
print(response.decode(encoding))

