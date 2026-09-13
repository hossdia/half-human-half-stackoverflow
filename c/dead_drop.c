#include <stdio.h>
#include <stdlib.h>
#include <time.h>
#include <unistd.h>

// Terminal color macros
#define RED     "\033[1;31m"
#define GREEN   "\033[1;32m"
#define YELLOW  "\033[1;33m"
#define CYAN    "\033[1;36m"
#define RESET   "\033[0m"

typedef struct {
    int credits;
    int heat;
    int cargo_val;
    int vehicle_hp;
} Player;

void print_status(Player *p) {
    printf("\n==========================================");
    printf("\n CREDITS: " GREEN "$%d" RESET " | HEAT: " RED "%d%%" RESET " | HP: " CYAN "%d%%" RESET, 
           p->credits, p->heat, p->vehicle_hp);
    printf("\n==========================================\n");
}

int handle_event(Player *p) {
    int roll = rand() % 100;
    
    // Checkpoint event triggers if roll is below current Heat
    if (roll < p->heat) {
        printf("\n" RED "[ALERT]" RESET " District patrol spotted your rig!\n");
        printf("[1] Bribe officer (-$150)\n");
        printf("[2] Burn through the blockade (Risk vehicle damage)\n");
        printf("[3] Ditch cargo (-$300 payout value, clear heat)\n");
        printf("Choice > ");
        
        int choice;
        scanf("%d", &choice);
        
        if (choice == 1) {
            if (p->credits >= 150) {
                p->credits -= 150;
                printf(GREEN "Paid off. Sector clear.\n" RESET);
            } else {
                printf(RED "Insufficient cash! They impounded part of your rig.\n" RESET);
                p->vehicle_hp -= 30;
                p->heat += 10;
            }
        } else if (choice == 2) {
            int evasion = rand() % 100;
            if (evasion > 40) {
                printf(GREEN "You blew through their line with minimal scrape!\n" RESET);
                p->vehicle_hp -= 10;
                p->heat += 15;
            } else {
                printf(RED "Spike strip! Heavy damage sustained.\n" RESET);
                p->vehicle_hp -= 40;
                p->heat += 25;
            }
        } else {
            printf(YELLOW "Payload dumped. Police lose interest.\n" RESET);
            p->cargo_val = 0;
            p->heat = (p->heat > 20) ? p->heat - 20 : 0;
        }
    } else {
        printf(GREEN "[SECURE]" RESET " Alleyway is quiet. No movement on scanners.\n");
    }
    
    return p->vehicle_hp > 0;
}

int main(void) {
    srand((unsigned int)time(NULL));
    Player player = { .credits = 500, .heat = 20, .cargo_val = 600, .vehicle_hp = 100 };

    printf(CYAN "=== DEAD DROP v0.1 initialized ===" RESET "\n");
    
    while (player.vehicle_hp > 0) {
        print_status(&player);
        printf("\n[1] Select Route: High-Speed Highway (Fast, High Heat)\n");
        printf("[2] Select Route: Industrial Back alleys (Slow, Low Heat)\n");
        printf("[3] Deliver Cargo (Drop Point)\n");
        printf("[4] Exit Terminal\n");
        printf("Choice > ");

        int action;
        if (scanf("%d", &action) != 1) break;

        if (action == 1) {
            printf("\nAccelerating through central bypass...\n");
            player.heat += 15;
            if (!handle_event(&player)) break;
        } else if (action == 2) {
            printf("\nNavigating back alleys...\n");
            player.heat += 5;
            if (!handle_event(&player)) break;
        } else if (action == 3) {
            if (player.cargo_val > 0) {
                printf(GREEN "\n[SUCCESS] Cargo dropped off. Received $%d payout." RESET "\n", player.cargo_val);
                player.credits += player.cargo_val;
                player.cargo_val = 600 + (rand() % 400); // Next job
                player.heat = (player.heat > 10) ? player.heat - 10 : 0;
            } else {
                printf(YELLOW "\nNo cargo to drop. Picked up new contract." RESET "\n");
                player.cargo_val = 500;
            }
        } else if (action == 4) {
            printf("Logging off...\n");
            break;
        }
    }

    if (player.vehicle_hp <= 0) {
        printf("\n" RED "=== VEHICLE DESTROYED / RIG SEIZED. GAME OVER. ===" RESET "\n");
    }

    return 0;
}