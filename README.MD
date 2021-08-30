# Skillbox Java Challenge III - Final Task

## Background

Team of engineers were trapped underground.

They were able to contact us, and they asked to 
get straight path to us in ground.

All the drilling machines were underground 
and we had to penetrate the ground with explosive shells.

Your mission - create model of ground after launch explosive strikes.

## Task

Implement method:

```java
public static String fire(int fieldSize, Strike[] strikes) {
        return "";
    }
```

Where `fieldSize` is height and width of ground part,
`strikes` is array of explosive shells that contains X coordinates
and strength of strike. Strikes apply sequentially from top of the ground.

Method must return structure of ground after launch all explosive strikes.

## Examples

`fieldSize = 5`

```
█████
█████
█████
█████
█████
```

Send strike with strength `ImpactForce.LITTLE` to X coordinate = 1.
LITTLE impact destroy the first one field that encountered.

```
█·███
█████
█████
█████
█████
```

Send one more with strength `ImpactForce.BIG` to X = 3.
BIG destroy one field that encountered and one field on the
right, bottom and left.

```
█····
███·█
█████
█████
█████
```

Ok, lets see, what happens if we send another BIG at X = 3,

```
█····
███·█
██···
███·█
█████
```

After that, field at X = 4, and one field from top hangs in the air.

```
█····
███·█ ←
██···
███·█
█████
```

Our planet have gravity. Field falls down before collision.

```
█····
███·· ↓
██··█ ←
███·█
█████
```

If multiple fields stay in the air, each field drop separately.

## Rules

- the whole field of ground is sign by █
- the empty space of ground is sign by ·
- if the strike does not meet an obstacle
in its path (fly through all fields) - nothing happens
- field or fields block fall if there is not any field bottom, right and left.

For example, after explosion you have:

```
█··█·
█·██·
···█·
█·█··
████·
```

Two blocks of fields in the air, after its drop down:

```
·····
█··█·
█·██·
█·██·
████·
```

Enjoy!