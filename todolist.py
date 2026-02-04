def show_tasks(tasks):
    if tasks:
        print("\nTo-Do List:")
        for idx, task in enumerate(tasks, 1):
            print(f"{idx}. {task}")
    else:
        print("\nNo tasks in your to-do list.")

def add_task(tasks):
    task = input("\nEnter a new task: ")
    tasks.append(task)
    print(f"Task '{task}' added to the list.")

def remove_task(tasks):
    show_tasks(tasks)
    if tasks:
        try:
            task_number = int(input("\nEnter the task number to remove: "))
            if 1 <= task_number <= len(tasks):
                removed_task = tasks.pop(task_number - 1)
                print(f"Task '{removed_task}' removed from the list.")
            else:
                print("Invalid task number.")
        except ValueError:
            print("Please enter a valid number.")

def main():
    tasks = []
    while True:
        print("\n-- To-Do List Manager --")
        print("1. View Tasks")
        print("2. Add Task")
        print("3. Remove Task")
        print("4. Exit")
        
        try:
            choice = int(input("Choose an option: "))
            
            if choice == 1:
                show_tasks(tasks)
            elif choice == 2:
                add_task(tasks)
            elif choice == 3:
                remove_task(tasks)
            elif choice == 4:
                print("Exiting the program.")
                break
            else:
                print("Invalid choice. Please try again.")
        except ValueError:
            print("Please enter a valid number.")

if __name__ == "__main__":
    main()