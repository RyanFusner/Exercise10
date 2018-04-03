package com.fusner.Exercise10;

import java.util.Iterator;
import java.util.NoSuchElementException;

public class Main {

    public static void main(String[] args)
    {
        Contact[] contacts = {new Contact("One", "emailOne@example.com"), new Contact("Two", "emailTwo@example.com"), new Contact("Three", "emailThree@example.com")};
        Book<Contact> contactBook = new Book<>(contacts);

        for (Contact contact: contactBook)
        {
            contact.sendEmail();
        }
    }
}

class Contact
{
    private String name;
    private String email;

    public String getName()
    {
        return name;
    }

    public void setName(String name)
    {
        this.name = name;
    }

    public String getEmail()
    {
        return email;
    }

    public void setEmail(String email)
    {
        this.email = email;
    }

    public Contact(String name, String email)
    {
        this.name = name;
        this.email = email;
    }

    public void sendEmail()
    {
        System.out.println("Emailing " + this.email);
    }
}

class Book<T> implements Iterable<T>
{
    T[] values;

    public Book(T[] values)
    {
        this.values = values;
    }

    class ArrayIterator implements Iterator<T>
    {
        int current = 0;

        public boolean hasNext()
        {
            if (current < Book.this.values.length)
            {
                return true;
            }
            else
            {
                return false;
            }
        }

        public T next()
        {
            if (!hasNext())
            {
                throw new NoSuchElementException();
            }
            return values[current++];
        }
    }

    public T get(int index)
    {
        return values[index];
    }

    public void set(int index, T value)
    {
        values[index] = value;
    }

    public int length()
    {
        return values.length;
    }

    public Iterator<T> iterator()
    {
        return new ArrayIterator();
    }
}

