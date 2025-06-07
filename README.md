# Dice Pal
## Introduction
Dice Pal is a CLI based Dice Rolling program for rolling RPG dice. It is written in Java.
The program takes an input string and parses it for dice information, and automatically performs dice rolls and sums the results.

For example:

```
/roll 1d20
```

You can roll any number or kind of dice.

```
/roll 2d10
```

and adding Arithmetic symbols (such as plus or minus) will allow you to add together the results of multiple dice, or any modifiers you want to include.

```
/roll 1d10 + 5 + 2d6
```

## How To

DicePal comes complete with a handful of commands, and there are plans to add more along the way. The most obvious command is the `/roll` command, but we also have:

| Command | Explanation                                                                                                                                                             |
| ------- | ----------------------------------------------------------------------------------------------------------------------------------------------------------------------- |
| `/roll` | Standard dice roll.                                                                                                                                                     |
| `/adv`  | Roll all dice with advantage. (NOTE! Multiple dice (`2d20`, will simply take the highest result of both `d20`'s rolled and summed. Current limitation of the program.)) |
| `/dis`  | Roll with Disadvantage.                                                                                                                                                 |
| `/npc`  | Roll a standard DND statblock using the `4d6` drop lowest method.                                                                                                       |

For rolling multiple sets of dice but separating the results, (such as for different damage types) you can separate the rolls with a comma. EG:

```
/roll 1d20 + 5, 1d12 + 7, 1d4 
```

This will return something like:

```
Result: 17, 13, 2
```

## Roadmap

I don't have a set roadmap for this. Mostly just working on it in my spare time. That said, I do have some planned features for future releases.

The plan is to introduce the ability to define custom rolls with a name. So if you, for example, constantly find yourself making a specific roll (eg, `2d10 + 12`), you can simply call that and have it roll automatically.

Additionally, there are plans to add different rolling methods to the NPC generator, either to account for different systems, or simply different stat generation methods (`eg, 1d20`). Could possibly introduce a "favored stat" where you write `/npc dex` and roll with advantage specifically on the dex stat. We'll see what I get around to.

At some point in the future I'd like to remake this program either in `C` or `Rust`.
