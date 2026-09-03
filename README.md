# S.O.L.I.D Principles Lab

Hands-on lab for the **Software Architectures** course at INSAT. Each module takes a small piece of Java code that violates one of the five SOLID principles and refactors it into a design that respects it.

Every module contains:

| Package | Purpose |
|---|---|
| `example` | A canonical violation of the principle, provided with the lab |
| `example_refactored` | The corrected version of that example |
| `exercise` | The exercise to solve: code that breaks the principle |
| `exercise_refactored` | My solution to the exercise |

Alongside each module there are two PlantUML class diagrams at the repo root: `XXX.puml` shows the structure before the refactoring and `XXXRef.puml` after it.

## Modules

### 1. SRP — Single Responsibility Principle

A class should have only one reason to change.

- **Before:** `CarManager` held the in-memory car database, looked cars up by id, formatted car names for display and picked the "best" car.
- **After:** data access moves to `CarRepository`, display formatting to `CarFormatter` and the "best car" rule to `CarRanker`. `CarManager` keeps its public API but only delegates, and receives its three collaborators through the constructor.

### 2. OCP — Open/Closed Principle

Software entities should be open for extension but closed for modification.

- **Before:** `ResourceAllocator` switched on a `ResourceType` enum (`TIME_SLOT`, `SPACE_SLOT`). Adding a new kind of resource meant editing every `switch` in the allocator.
- **After:** a `ResourcePool` interface (`findFreeSlot`, `markBusy`, `markFree`) is implemented by `TimeSlotPool` and `SpaceSlotPool`. The allocator works against the interface, so a new resource type is a new class, not an edit to the allocator.

### 3. LSP — Liskov Substitution Principle

Subtypes must be usable wherever their base type is expected without breaking the program.

- **Before:** `ElectronicDuck extends Duck` but throws `RuntimeException` from `quack()` and `swim()` while switched off, so `Pool` crashes when it treats it as a plain `Duck`.
- **After:** `Duck` becomes an interface whose contract is that `quack()` and `swim()` always complete normally. `RealDuck` and `ElectronicDuck` both implement it, and the electronic one does nothing while switched off instead of throwing. Its power state lives in a separate `Switchable` interface, so `Pool` can mix both kinds of duck safely.

### 4. ISP — Interface Segregation Principle

Clients should not be forced to depend on methods they do not use.

- **Before:** a single `Door` interface bundled `lock/unlock/open/close` with `timeOutCallback()` and `proximityCallback()`. `TimedDoor` had to stub out the proximity callback and `SensingDoor` the timeout callback.
- **After:** `Door` keeps only the core door operations. The callbacks become `TimeOutListener` and `ProximityListener`, `Timer` and `Sensor` register against those small interfaces, and each door implements only what it actually reacts to.

### 5. DIP — Dependency Inversion Principle

High-level modules should depend on abstractions, not on low-level details.

- **Before:** `EncodingModule` created its own `FileReader`, `FileWriter`, `URL` stream and `MyDatabase` inside two hard-coded methods, one per input/output combination.
- **After:** `EncodingModule` depends on two abstractions, `DataSource` and `DataSink`, injected through its constructor, and has a single `encode()` method. `FileSource`, `UrlSource`, `FileSink` and `DatabaseSink` (an adapter over `MyDatabase`) implement them. `EncodingModuleClient` is the only place that knows the concrete classes and wires any source to any sink.

## Project layout

```
.
├── SRP/  OCP/  LSP/  ISP/  DIP/     one IntelliJ module per principle
│   └── src/com/directi/training/<principle>/
│       ├── example/
│       ├── example_refactored/
│       ├── exercise/
│       └── exercise_refactored/
├── *.puml                            class diagrams, before (XXX) and after (XXXRef)
├── lib/                              JUnit 4.13.2 and Hamcrest, used by the LSP tests
```

## Running

The project is set up for IntelliJ IDEA: open the root folder and each principle appears as a module. Any class with a `main` method (for example `Pool`, `PoolElectronic`, `EncodingModuleClient`) can be run directly.

From the command line, compile and run a single module with:

```bash
javac -d out -cp lib/junit-4.13.2.jar:lib/hamcrest-core-1.3.jar $(find LSP/src -name '*.java')
java -cp out com.directi.training.lsp.exercise_refactored.Pool
```

The LSP module includes JUnit tests (`RectangleTest`, `SquareTest`) that demonstrate the classic Rectangle/Square substitution problem and its fix.

To render a diagram, use any PlantUML tool, for example:

```bash
plantuml SRPRef.puml
```
