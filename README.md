# Car Marketplace Web Application

Project which involves a Web Page which resembles Car Marketplace functionalities.

## Overview

The application provides a multi-role access model with three types of users:

- **Visitor**: A non-authenticated user with access only to public publication information.
- **Registered User**: A registered user who can create and manage vehicle publications and is exposed to other user's personal info.
- **Administrator**: A registered user with more privileges for managing the system and user content.

Access to specific parts of the application is restricted based on the user's role. Visitors are explicitly denied access to any functionality that is reserved for registered users.

## Functionalities

- User registration and login
- Role-based access control enforced via Spring Security
- Vehicle listing and detailed view
- User account management for registered users
- Vehicle publication creation and management
- Administrative tools for managing publications and users (for administrators)

## Application Pages

- **Main Page**: Displays available vehicle publications alongside with enabling user to search and filter out the desired vehicle. Accessible to all users.
- **Vehicle Details Page**: Shows detailed information about a specific vehicle. Accessible to all users with restrictions for Visitor.
- **User Account Page**: Allows registered users to view and manage their account information with ability to log out.
- **Publication Creation Page**: Accessible only to registered users for creating new vehicle publications.
- **Publication Managing Page**: Accessible only to registered users for changin a status of a publication (setting active or inactive) .
