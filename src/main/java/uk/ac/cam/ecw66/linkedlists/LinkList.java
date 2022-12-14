/*
 * Copyright 2022 Ben Philps <bp413@cam.ac.uk>, Andrew Rice <acr31@cam.ac.uk>, E.C. Worth
 *
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 *
 *    http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */

package uk.ac.cam.ecw66.linkedlists;

import java.util.NoSuchElementException;

public class LinkList {

  private static class Node {
    private int value;
    private Node next;

    public Node(int value, Node next) {
      this.value = value;
      this.next = next;
    }

    Node(int value) {
      this.value = value;
      this.next = null;
    }

    @Override
    public String toString() {
      if (next == null) {
        return String.valueOf(value);
      }
      return value + "," + next;
    }

    private int get(int i) {
      if (i == 0) {
        return value;
      } else if (next == null) {
        throw new NoSuchElementException();
      } else {
        return next.get(i - 1);
      }
    }

    private int length() {
      if (next == null) {
        return 1;
      } else {
        return 1 + next.length();
      }
    }
  }

  private Node head;

  LinkList() {
    this.head = null;
  }

  void addFirst(int element) {
    if (head == null) {
      head = new Node(element);
    } else {
      head = new Node(element, head);
    }
  }

  public int removeFirst() {
    if (head == null) {
      throw new NoSuchElementException();
    } else {
      int temp = head.value;
      head = head.next;
      return temp;
    }
  }

  @Override
  public String toString() {
    return String.format("[%s]", head == null ? "" : head.toString());
  }

  public static LinkList create(int[] elements) {
    LinkList ll = new LinkList();
    for (int i = elements.length - 1; i >= 0; --i) {
      ll.addFirst(elements[i]);
    }
    return ll;
  }

  public int get(int i) {
    if (i < 0 || head == null) {
      throw new NoSuchElementException();
    } else {
      return head.get(i);
    }
  }

  public int length() {
    if (head == null) {
      return 0;
    } else {
      return head.length();
    }
  }
}
