import time
import random

class TrafficSignalReflexAgent:
    def __init__(self, initial_state="red"):
        self.state = initial_state
        self.traffic_density = random.choice(["low", "medium", "high"])  # Simulate random initial traffic

    def perceive(self):
        """Simulates perceiving the current state of the traffic signal and traffic density."""
        # In a real system, this would involve sensors
        self.traffic_density = random.choice(["low", "medium", "high"])  # Simulate changing traffic
        return self.state, self.traffic_density

    def rule_match(self, state, traffic_density):
        """Matches the current state and traffic density to an action rule."""
        if state == "red" and traffic_density == "low":
            return "wait_short"
        elif state == "red" and traffic_density == "medium":
            return "wait_medium"
        elif state == "red" and traffic_density == "high":
            return "wait_long"
        elif state == "green" and traffic_density == "low":
            return "go_long"
        elif state == "green" and traffic_density == "medium":
            return "go_medium"
        elif state == "green" and traffic_density == "high":
            return "go_short"
        elif state == "yellow":
            return "caution"
        else:
            return "unknown state"

    def act(self, action):
        """Simulates performing an action based on the rule."""
        if action == "wait_short":
            print("🚦 Signal: RED | Traffic: LOW → Waiting short time...")
        elif action == "wait_medium":
            print("🚦 Signal: RED | Traffic: MEDIUM → Waiting medium time...")
        elif action == "wait_long":
            print("🚦 Signal: RED | Traffic: HIGH → Waiting long time...")
        elif action == "go_long":
            print("✅ Signal: GREEN | Traffic: LOW → Go for a long time!")
        elif action == "go_medium":
            print("✅ Signal: GREEN | Traffic: MEDIUM → Go for a medium time!")
        elif action == "go_short":
            print("✅ Signal: GREEN | Traffic: HIGH → Go for a short time!")
        elif action == "caution":
            print("⚠️ Signal: YELLOW → Caution!")
        else:
            print(f"❓ Unknown action: {action}")

    def run(self, cycles=5):
        """Simulates the agent running through a few cycles with random state transitions."""
        for i in range(cycles):
            print(f"\n--- Cycle {i + 1} ---")

            # Logical state transitions
            if self.state == "red":
                self.state = random.choice(["green", "red"])  # Stay red or go green
            elif self.state == "green":
                self.state = random.choice(["yellow", "green"])  # Stay green or go yellow
            elif self.state == "yellow":
                self.state = "red"  # Always go to red from yellow

            perceived_state, perceived_traffic = self.perceive()
            action = self.rule_match(perceived_state, perceived_traffic)
            self.act(action)
            time.sleep(1)  # Simulate time passing

# Create and run the agent with more cycles
traffic_agent = TrafficSignalReflexAgent()
traffic_agent.run(cycles=10)
