/**
 * Bristlecone Test Tools for Databases
 * Copyright (C) 2006-2007 Continuent Inc.
 * Contact: bristlecone@lists.forge.continuent.org
 *
 * This program is free software; you can redistribute it and/or modify
 * it under the terms of version 2 of the GNU General Public License as
 * published by the Free Software Foundation.
 *
 * This program is distributed in the hope that it will be useful,
 * but WITHOUT ANY WARRANTY; without even the implied warranty of
 * MERCHANTABILITY or FITNESS FOR A PARTICULAR PURPOSE.  See the
 * GNU General Public License for more details.
 *
 * You should have received a copy of the GNU General Public License
 * along with this program; if not, write to the Free Software
 * Foundation, Inc., 59 Temple Place - Suite 330, Boston, MA 02111-1307, USA
 *
 * Initial developer(s): Robert Hodges and Ralph Hannus.
 * Contributor(s): Linas Virbalas
 */

package com.continuent.bristlecone.benchmark.db;

/**
 * Generates double values.
 * 
 * @author rhodges
 */
public class DataGeneratorForDouble implements DataGenerator
{
  private static final boolean astronomicalNumbersOnly = false;

  /** Create a new instance. */
  DataGeneratorForDouble()
  {
  }

  /** Generate next value up to the boundary value. */
  public Object generate()
  {
    double max = 0;
    if (astronomicalNumbersOnly)
    {
      // Max from float so that this works better with oracle.
      max = Float.MAX_VALUE;
    }
    else
    {
      // REP-132 - must use different magnitude each time, otherwise we
      // generate only astronomical numbers.
      double magnitude = (int) (38 * Math.random());
      // 3.4028235 is Float.MAX_VALUE without power.
      max = 3.4028235 * Math.pow(10, magnitude);
    }

    double sign = (Math.random() >= 0.5) ? -1.0 : 1.0;
    double absvalue = (Math.random() * max);
    return new Double(sign * absvalue);
  }
}