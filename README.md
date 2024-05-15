# Postal-Code-Management-System
Code used to manipulate postal codes and orders them based on their longitude
Postal Code Management System

Description:
This program implements a postal code management system that allows users to store, retrieve, and manipulate postal code information. It includes classes for representing postal codes, a hash map data structure for efficient storage and retrieval, and sorting algorithms for organizing postal codes based on different criteria.

Contents:

PostalCode.java: Defines the PostalCode class, which represents individual postal codes. It includes attributes such as code, area, province, latitude, and longitude, along with methods for accessing and modifying these attributes.

AbstractHashMap.java: Provides an abstract base class for implementing hash map data structures. It includes common methods and functionality used by concrete hash map implementations.

LinkedPositionalChainHashMap.java: Implements a hash map using separate chaining with linked lists for collision resolution. It utilizes the LinkedPositionalList class for maintaining the linked lists.

LinkedPositionalList.java: Defines a doubly linked list data structure with positional access. It includes methods for adding, removing, and accessing elements in the list.

OrderByLongitude.java: Implements a comparator for sorting postal codes based on longitude.

PostalDriver.java: Contains the main driver program for the postal code management system. It reads postal code data from a file, stores it in a hash map, allows users to sort and display the data, and performs various operations such as adding, updating, and removing postal codes.

QuickSort.java: Provides a generic implementation of the quicksort algorithm for sorting elements in a queue data structure.

SinglyLinkedList.java: Implements a singly linked list data structure with basic operations such as adding, removing, and accessing elements.

DefaultComparator.java: Implements a default comparator for comparing generic elements using their natural ordering.

README.md: This file. Provides an overview of the program, its contents, and instructions for running and contributing to the project.

Usage:

Compile the Java files
Run the main driver program
Follow the on-screen prompts to interact with the postal code management system.
