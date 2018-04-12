# Simple Auth
A simple form authentication testing webserver written in kotlin.

A website will check for a match with `root:password` creds and `Specific UA/1.0` user agent.

It may easly be tested using [httpie](https://github.com/jakubroztocil/httpie) tool like :
```
http --form POST localhost:7000/login login="root" pass="password" User-Agent:Specific\ UA/1.0
```
for a success and 
```
http --form POST localhost:7000/login login="root" pass="password" User-Agent:Specific\ UA/0.0
```
for fail (notice UA doesn't match).
