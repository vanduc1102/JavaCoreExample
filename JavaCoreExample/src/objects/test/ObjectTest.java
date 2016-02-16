/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package objects.test;

import java.util.Objects;

/**
 *
 * @author nvduc
 */
public class ObjectTest {
    public static void main(String[] args) {
        Integer a = new Integer(10);
        Integer b = new Integer(10);
        System.out.println("Compare "+Objects.equals(a,b));
    }
}
