# RAAZ
A tea and manufacturer inventory application

Java II final project by Rachel Schulz, Amy Miles, Amber Miler, and Zoie Firkins

## Contents of this file

 - Introduction
 - Requirements
 - Installation
 - Troubleshooting
 - Contributers/Maintainers
 
## Introduction

RAAZ (Rachel, Amy, Amber, Zoie) is a spring boot application that houses inventory and manufacturer information for a ficticious tea company.

- To view all files or clone the repo, visit the [RAAZ repository](https://github.com/Torirem03/RAAZ).
- Use the [Issue queue](https://github.com/Torirem03/RAAZ/issues) to submit bug reports and feature suggestions, or track changes.

## Requirements

This project requires:

- Eclipse IDE version 2023-09 (4.29.0) or later
- Lombok v1.18.30 "Envious Ferret" or later
- Maven 4.0.0 or later
- Springboot 3.1.5 or later

## Installation

Install as you would normally install a Eclipse project from a repository into your package explorer. See [Eclipse documentation](https://help.eclipse.org/latest/index.jsp?topic=%2Forg.eclipse.platform.doc.user%2Freference%2Fref-27.htm) or visit https://help.eclipse.org/ for further information.

## Troubleshooting

- Setup RAAZ database locally using MySql so that you can add, delete, and edit inventory data.

	`spring.datasource.url=jdbc:mysql://localhost:3306/RAAZ?userSSL=false`

- Ensure your datasource username and password are correct in the application.properties file

	`spring.datasource.username=root`
	`spring.datasource.password=(YourPassword)`


## Contributers/Maintainers

Current maintainers:
- Amber Miller ([Torirem03](https://github.com/Torirem03))
- Amy Miles ([amy-miles](https://github.com/amy-miles))
- Rachel Schulz ([RachelSchulz](https://github.com/RachelSchulz))
- Zoie Firkins ([zmfirkins](https://github.com/zmfirkins))
