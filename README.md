# Pattern Oriented Software Design - Term Project

## Cons: Implementation of R-tree Using RxJava with Extension to Spring Framework

Team members:

* 112598056 陳威廷
* 112598061 許喬睿

## Problem Statement
    
在資料探勘領域，隨著大數據的興起，「查詢優化」已成為熱門的研究課題。許多資深研究人員致力於開發和探索各種演算法與方法，旨在減少查詢時間，甚至藉助 AI 模型進一步提升效能。然而，即使在這些前沿技術中，經典的查詢技術如 R-tree，仍然扮演著不可或缺的基礎角色。

同時，在 Java 軟體開發領域，Spring 和 React 的持續流行得益於其對設計模式 (Design Patterns) 的高度實現。其中，React 是 Spring 框架中專門實現觀察者模式 (Observer Pattern) 的一個工具，為構建動態響應式系統提供支持。這種技術特性使其在企業級資料庫專案中展現出極高的相關性和應用價值。

## Description

本專題聚焦於利用 RxJava 實現 R-tree 的基礎上，進一步擴展為基於 Spring Framework 的專題。透過該專案，模擬並探索符合設計模式 (Design Patterns) 的企業級資料庫系統的小型版本。同時，專案將深入研究並實現 React 與 Spring 的運作機制與核心原理，以加深對這些技術的理解。

## Future

R-tree 是許多資料查詢優化技術的基石，因此將其封裝為套件，應用於其他查詢優化程序，或直接作為查詢優化方法的擴展，具有廣泛的實用性與發展潛力。

## Technique

1. R-tree
> R-Tree 是一種樹形資料結構，專門用於存儲多維空間的資料，例如 2D 或 3D 的地理位置數據。它主要用於處理空間查詢（如範圍查詢和最近鄰查詢），廣泛應用於地理資訊系統 (GIS)、計算機圖形學、和空間資料庫。
2. RxJava/React
> RxJava是ReactiveX項目的Java實現，基於"響應式編成"理念，提供了一個異步數據流的處理框架。而React則可視為Spring提供的類RxJava套件，使用方式基本相同。
3. Spring
> Spring 是一個功能強大的開源 Java 框架，主要用於簡化企業級應用的開發。它提供了全面的基礎設施，涵蓋應用程序的配置、數據訪問、事務管理、Web 開發和安全等多個領域。Spring 框架以其靈活性和模塊化設計而著稱，是 Java 生態系統中的核心技術之一。
## Design Patterns Summary & Storyboard

## Design Patterns in Our Code

### Patterns on RxJava

1. Observer Pattern
> 支持同步和異步事件流
2. Decorator Pattern
> 使用操作符(Operators)對Observable進行包裝，形成新的Observable，從而實現功能的增強或改變
3. Strategy Pattern
> 利用不同的Scheduler提供不同的現成執行策略

### Patterns on Spring

1. Factory Pattern
> BeanFactory和Application便是典型的Factory Pattern的實現，負責創建和管理Bean對象
2. Proxy Pattern
> AOP功能通過動態代理實現方法的攔截和增強
3. Singleton Pattern
> 默認情況下，Spring中的Bean是單例的，由容器負責管理其生命週期  
4. Template Pattern
>在數據庫操作中，定義了固定的操作流程，具體實現由子類完成
5. Adapter Pattern:
>在Spring MVC中，使用了HandlerAdapter，將不同類型的請求處理器適配為統一的街口
