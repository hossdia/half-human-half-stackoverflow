#include <stdio.h>
#include <stdlib.h>
#include <time.h>
#include <string.h>

// Terminal color macros
#define RED     "\033[1;31m"
#define GREEN   "\033[1;32m"
#define YELLOW  "\033[1;33m"
#define CYAN    "\033[1;36m"
#define RESET   "\033[0m"

#define MAX_LOCATIONS 5
#define MAX_ROUTES 2
#define MAX_JOBS 3

typedef struct {
    int credits;
    int heat;
    int vehicle_hp;
} Player;

typedef struct {
    char name[32];
    char locations[MAX_LOCATIONS][32];
    int location_count;
} Route;

typedef struct {
    char cargo_name[32];
    int payout;
    int heat_risk;
    Route routes[MAX_ROUTES];
} Job;


// PLAYER FUNCTIONS
void print_status(const Player *p) {
    printf("\n==========================================\n");
    printf(" CREDITS:    " GREEN "$%d" RESET "\n", p->credits);
    printf(" HEAT:       " RED "%d%%" RESET "\n", p->heat);
    printf(" VEHICLE HP: " CYAN "%d%%" RESET "\n", p->vehicle_hp);
    printf("==========================================\n");
}

void apply_damage(Player *p, int amount) {
    p->vehicle_hp -= amount;

    if (p->vehicle_hp < 0) {
        p->vehicle_hp = 0;
    }
}

void add_heat(Player *p, int amount) {
    p->heat += amount;

    if (p->heat > 100) {
        p->heat = 100;
    }
}


// JOB DATA
void init_jobs(Job jobs[]) {

    // ---------------------------------------------------------
    // JOB 0: UNMARKED PACKAGE
    // $750 | Medium Length | Medium Heat
    // ---------------------------------------------------------

    strcpy(jobs[0].cargo_name, "Unmarked Package");
    jobs[0].payout = 750;
    jobs[0].heat_risk = 15;

    // Route 1
    strcpy(jobs[0].routes[0].name, "Industrial Route");

    strcpy(jobs[0].routes[0].locations[0], "Warehouse Row");
    strcpy(jobs[0].routes[0].locations[1], "Service Alley");
    strcpy(jobs[0].routes[0].locations[2], "Old Bridge");

    jobs[0].routes[0].location_count = 3;

    // Route 2
    strcpy(jobs[0].routes[1].name, "Highway Bypass");

    strcpy(jobs[0].routes[1].locations[0], "Outer Highway");
    strcpy(jobs[0].routes[1].locations[1], "Toll Plaza");
    strcpy(jobs[0].routes[1].locations[2], "Industrial Park");

    jobs[0].routes[1].location_count = 3;


    // ---------------------------------------------------------
    // JOB 1: FRAGILE TECH
    // $1100 | Long Route | Higher Risk
    // ---------------------------------------------------------

    strcpy(jobs[1].cargo_name, "Fragile Tech");
    jobs[1].payout = 1100;
    jobs[1].heat_risk = 25;

    // Route 1
    strcpy(jobs[1].routes[0].name, "Suburban Backroads");

    strcpy(jobs[1].routes[0].locations[0], "Residential Zone");
    strcpy(jobs[1].routes[0].locations[1], "Drainage Canal");
    strcpy(jobs[1].routes[0].locations[2], "Rail Yard");
    strcpy(jobs[1].routes[0].locations[3], "Drop Point");

    jobs[1].routes[0].location_count = 4;

    // Route 2
    strcpy(jobs[1].routes[1].name, "Metro Underground");

    strcpy(jobs[1].routes[1].locations[0], "Subway Tunnel");
    strcpy(jobs[1].routes[1].locations[1], "Maintenance Hub");
    strcpy(jobs[1].routes[1].locations[2], "Freight Terminal");
    strcpy(jobs[1].routes[1].locations[3], "Drop Point");

    jobs[1].routes[1].location_count = 4;


    // ---------------------------------------------------------
    // JOB 2: RUSH CONTRACT
    // $1400 | Short Route | High Heat
    // ---------------------------------------------------------

    strcpy(jobs[2].cargo_name, "Rush Contract");
    jobs[2].payout = 1400;
    jobs[2].heat_risk = 40;

    // Route 1
    strcpy(jobs[2].routes[0].name, "Downtown Expressway");

    strcpy(jobs[2].routes[0].locations[0], "Financial District");
    strcpy(jobs[2].routes[0].locations[1], "Downtown Checkpoint");

    jobs[2].routes[0].location_count = 2;

    // Route 2
    strcpy(jobs[2].routes[1].name, "Commercial Strip");

    strcpy(jobs[2].routes[1].locations[0], "Shopping District");
    strcpy(jobs[2].routes[1].locations[1], "Port Entrance");

    jobs[2].routes[1].location_count = 2;
}


// CHECKPOINT EVENT
int run_checkpoint_event(Player *p) {

    int choice;

    printf("\n" RED "[ALERT]" RESET
           " District patrol spotted your rig!\n");

    printf("[1] Bribe officer (-$150)\n");
    printf("[2] Burn through the blockade\n");
    printf("[3] Ditch cargo\n");
    printf("Choice > ");

    if (scanf("%d", &choice) != 1) {
        return 0;
    }

    // BRIBE OFFICER
    if (choice == 1) {

        if (p->credits >= 150) {

            p->credits -= 150;

            printf(GREEN
                   "> Paid off. Sector clear. -$150\n"
                   RESET);

        } else {

            printf(RED
                   "> Insufficient cash! They impounded part of your rig.\n"
                   RESET);

            apply_damage(p, 30);
            add_heat(p, 10);
        }

        return p->vehicle_hp > 0;
    }


    // PUSH THROUGH
    if (choice == 2) {

        int evasion = rand() % 100;

        if (evasion > 40) {

            printf(GREEN
                   "> You blew through their line with minimal scrape!\n"
                   RESET);

            apply_damage(p, 10);
            add_heat(p, 15);

        } else {

            printf(RED
                   "> Spike strip! Heavy damage sustained.\n"
                   RESET);

            apply_damage(p, 40);
            add_heat(p, 25);
        }

        return p->vehicle_hp > 0;
    }


    // DITCH CARGO
    if (choice == 3) {

        printf(YELLOW
               "> Payload dumped. Job failed.\n"
               RESET);

        return 0;
    }


    printf(YELLOW "> Invalid choice. You hesitate...\n" RESET);

    return 1;
}

// RUN A JOB
int execute_run(Player *p, const Job *job, int route_index) {

    const Route *route = &job->routes[route_index];

    printf("\n==========================================\n");
    printf(" CARGO: %s\n", job->cargo_name);
    printf(" ROUTE: %s\n", route->name);
    printf(" PAYOUT: $%d\n", job->payout);
    printf("==========================================\n");

    for (int i = 0; i < route->location_count; i++) {

        printf("\n> Entering %s...\n",
               route->locations[i]);

        /*
         * For Sprint 1:
         * checkpoint can occur at intermediate locations.
         */
        if (i > 0 &&
            i < route->location_count - 1 &&
            rand() % 2 == 0) {

            if (!run_checkpoint_event(p)) {
                return 0;
            }

            if (p->vehicle_hp <= 0) {
                return 0;
            }
        }
    }


    // DELIVERY
        p->credits += job->payout;
    add_heat(p, job->heat_risk);

    printf("\n==========================================\n");
    printf(GREEN "          DROP COMPLETE\n" RESET);
    printf("==========================================\n");

    printf("Cargo:  %s\n", job->cargo_name);
    printf("Payout: " GREEN "+$%d" RESET "\n", job->payout);
    printf("Heat:   " RED "+%d%%" RESET "\n", job->heat_risk);

    return 1;
}


// MAIN


int main(void) {

    srand((unsigned int)time(NULL));

    Player player = {
        .credits = 500,
        .heat = 20,
        .vehicle_hp = 100
    };

    Job jobs[MAX_JOBS];

    init_jobs(jobs);

    printf(CYAN
           "\n=== DEAD DROP v0.1 initialized ===\n"
           RESET);


    // MAIN GAME LOOP
    while (player.vehicle_hp > 0) {

        print_status(&player);

        // Pick a random job
        int current_job = rand() % MAX_JOBS;

        Job *job = &jobs[current_job];

        printf("\n==========================================\n");
        printf("          NEW JOB OFFERED\n");
        printf("==========================================\n");

        printf("Cargo:  %s\n", job->cargo_name);
        printf("Payout: $%d\n", job->payout);
        printf("Heat:   +%d%%\n\n", job->heat_risk);

        printf("[1] %s\n", job->routes[0].name);
        printf("[2] %s\n", job->routes[1].name);
        printf("[3] Reject / Quit Game\n");

        printf("Choice > ");

        int choice;

        if (scanf("%d", &choice) != 1) {
            break;
        }


        // SELECT ROUTE
        if (choice == 1 || choice == 2) {

            int route_index = choice - 1;

            execute_run(
                &player,
                job,
                route_index
            );

        }

        // QUIT

        else if (choice == 3) {

            printf("\nLogging off...\n");
            break;

        }

        // INVALID INPUT
        else {

            printf(YELLOW
                   "\nInvalid choice.\n"
                   RESET);
        }
    }

    // GAME OVER
    if (player.vehicle_hp <= 0) {

        printf("\n" RED
               "==========================================\n"
               "       VEHICLE DESTROYED / RIG SEIZED\n"
               "                 GAME OVER\n"
               "==========================================\n"
               RESET);
    }

    return 0;
}