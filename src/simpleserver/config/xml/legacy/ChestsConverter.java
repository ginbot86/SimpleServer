/*
 * Copyright (c) 2010 SimpleServer authors (see CONTRIBUTORS)
 *
 * Permission is hereby granted, free of charge, to any person obtaining a copy
 * of this software and associated documentation files (the "Software"), to deal
 * in the Software without restriction, including without limitation the rights
 * to use, copy, modify, merge, publish, distribute, sublicense, and/or sell
 * copies of the Software, and to permit persons to whom the Software is
 * furnished to do so, subject to the following conditions:
 * The above copyright notice and this permission notice shall be included in
 * all copies or substantial portions of the Software.
 *
 * THE SOFTWARE IS PROVIDED "AS IS", WITHOUT WARRANTY OF ANY KIND, EXPRESS OR
 * IMPLIED, INCLUDING BUT NOT LIMITED TO THE WARRANTIES OF MERCHANTABILITY,
 * FITNESS FOR A PARTICULAR PURPOSE AND NONINFRINGEMENT. IN NO EVENT SHALL THE
 * AUTHORS OR COPYRIGHT HOLDERS BE LIABLE FOR ANY CLAIM, DAMAGES OR OTHER
 * LIABILITY, WHETHER IN AN ACTION OF CONTRACT, TORT OR OTHERWISE, ARISING FROM,
 * OUT OF OR IN CONNECTION WITH THE SOFTWARE OR THE USE OR OTHER DEALINGS IN
 * THE SOFTWARE.
 */
package simpleserver.config.xml.legacy;

import java.util.Stack;

import org.xml.sax.Attributes;
import org.xml.sax.SAXException;

import simpleserver.config.xml.Chests;
import simpleserver.config.xml.Permission;
import simpleserver.config.xml.PermissionContainer;

public class ChestsConverter extends TagConverter {

  ChestsConverter() {
    super("chests");
  }

  @Override
  void convert(Attributes attributes, Stack<PermissionContainer> stack) throws SAXException {
    PermissionContainer container = stack.peek();
    Chests chests = new Chests(new Permission(attributes.getValue("allow"), attributes.getValue("disallow")));
    chests.fullInit();

    container.chests.chests = chests;
  }

}
